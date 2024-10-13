package javaguide.concurrency.basic;

import java.lang.String;

public class DeadLockDemo {

    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        //Thread 1
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource 1");
                try {
                    Thread.sleep(1000); //为了保证让线程2得到运行， 一个线程一次最多只能在 CPU 上运行比如 10-20ms 的时间
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread() + "wait get resource 2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource 2");
                }
            }
        }).start();

        //Thread 2
        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource 2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread() + "wait get resource 1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread() + "get resource 1");
                }
            }
        }).start();
    }

}
