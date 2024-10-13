package javaguide.concurrency.aqs;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class AQSExample {
    public static void main(String[] args) {
        AbstractQueuedSynchronizer synchronizer = new AbstractQueuedSynchronizer() {
            @Override
            protected boolean tryAcquire(int arg) {
                return super.tryAcquire(arg);
            }

            @Override
            protected boolean tryRelease(int arg) {
                return super.tryRelease(arg);
            }

            @Override
            protected int tryAcquireShared(int arg) {
                return super.tryAcquireShared(arg);
            }

            @Override
            protected boolean tryReleaseShared(int arg) {
                return super.tryReleaseShared(arg);
            }
        };
    }
}
