package javaguide.concurrency.basic;

//查看字节码：
// 1. javac -encoding UTF-8 SynchronizedTest.java
// 2. javap -c -s -v -l SynchronizedTest.class

public class SynchronizedTest {
    //1. synchronized 代码块
    public void method1(){
        synchronized (this){
            System.out.println("Synchronized code");
        }
    }

    //2. synchronized 方法
    synchronized public void method2(){
            System.out.println("Synchronized method");
    }

    //3. synchronized 静态方法
    synchronized public static void method3(){
        System.out.println("Synchronized static method");
    }
}
