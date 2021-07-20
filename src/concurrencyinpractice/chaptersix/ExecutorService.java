package concurrencyinpractice.chaptersix;

import java.util.List;
import java.util.concurrent.TimeUnit;

public interface ExecutorService extends  Executor{
    void shutdown();
    List<Runnable> shutdownNow();
    boolean isShutdown();
    boolean isTerminated();
    boolean awaitTermination(long timeout, TimeUnit timeUnit) throws InterruptedException;
}
