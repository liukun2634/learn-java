package javaguide.concurrency.basic;



public class ThreadJoinTest {
    //静态内部类，可以从外面访问到该类
    public static class TestThread extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread() + ":  running thread t");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new TestThread();
        t.start();
        t.join();
        System.out.println(Thread.currentThread() +  ": wait thread t finished");
        Thread t2 = new Thread(() ->{
            System.out.println(Thread.currentThread() + ":  running thread t2");
        });
        t2.start();
    }
}
