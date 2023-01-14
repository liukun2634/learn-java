package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLockTest {

    public static void main(String[] args) {
        new SpinLockTest().runTask();

    }

    private void runTask() {
        AtomicBoolean cas = new AtomicBoolean();
        Thread thread1 = new Thread(new SpinTask(cas));
        Thread thread2 = new Thread(new SpinTask(cas));
        thread1.start();
        thread2.start();
    }

    class SpinTask implements Runnable {
        private AtomicBoolean cas;
        private SpinLock spinLock;

        public SpinTask(AtomicBoolean cas) {
            this.cas = cas;
            this.spinLock = new SpinLock(cas);
        }

        @Override
        public void run() {
            spinLock.lock();
            System.out.println("getLock");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unlock();
            System.out.println("unLock");
        }
    }


    class SpinLock {
        private AtomicBoolean available;

        public SpinLock(AtomicBoolean available) {
            this.available = available;
        }

        public void lock() {
            while (!tryLock()) {
                //spin for get lock
            }
        }

        public boolean tryLock() {
            return available.compareAndSet(false, true);
        }

        public void unlock() {
            if (!available.compareAndSet(true, false)) {
                throw new RuntimeException("Fail to unlock");
            }
        }
    }

}
