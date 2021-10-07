package javaguide.concurrency.basic;


public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<Integer> local = new ThreadLocal<>();
        Thread thread = new Thread(() -> {System.out.println("Test");});
        
    }
}
