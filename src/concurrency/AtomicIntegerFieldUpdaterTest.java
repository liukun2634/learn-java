package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
    private static final int THREAD_NUM = 100;

    private volatile int counter;
    private final static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterTest> atomicIntegerFieldUpdater
            = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterTest.class, "counter");


    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(THREAD_NUM);

        AtomicIntegerFieldUpdaterTest test = new AtomicIntegerFieldUpdaterTest();

        for(int i = 0; i < THREAD_NUM; i++) {
            new Thread(() -> {
                atomicIntegerFieldUpdater.incrementAndGet(test);
                latch.countDown();
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter is " + test.counter);
    }


}
