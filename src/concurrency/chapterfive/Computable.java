package concurrency.chapterfive;

public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
