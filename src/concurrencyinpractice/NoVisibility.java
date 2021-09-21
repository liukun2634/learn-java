package concurrencyinpractice;

import java.lang.String;

public class NoVisibility {
    private static boolean ready;
    private static int number;


    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)  //1. ready may still be false
                Thread.yield();
            System.out.println(number); //2.output may be 0
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
