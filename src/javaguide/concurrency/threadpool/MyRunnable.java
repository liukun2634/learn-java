package javaguide.concurrency.threadpool;

import java.lang.String;

import java.util.Date;

public class MyRunnable implements Runnable{
    private String id;

    public MyRunnable(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End Time = " + new Date());
    }

    private void processCommand() {
        try {
            System.out.println("ID: " + this.id + " are in process");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.id;
    }
}
