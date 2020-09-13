package concurrency.chapterfive;

import java.util.Map;
import java.util.concurrent.*;

public class Memoizer4<A, V> implements Computable<A, V> {
    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer4(Computable<A, V> c) {
        this.c = c;
    }


    @Override
    public V compute(final A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<>(eval);
            //Use put if absent for atomic
            f = cache.putIfAbsent(arg, ft);
            //if not exist, run FutureTask
            if ( f == null ) {
                f = ft;
                ft.run();
            }
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
