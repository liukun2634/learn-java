# 概念

- 进程
- 线程


##  Runnable 与  Callable 

Runnable 

```java
 /*
 * @author  Arthur van Hoff
 * @see     java.lang.Thread
 * @see     java.util.concurrent.Callable
 * @since   JDK1.0
 */
@FunctionalInterface
public interface Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see     java.lang.Thread#run()
     */
    public abstract void run();
}
```

Callable
```java
 /* <p>The {@link Executors} class contains utility methods to
 * convert from other common forms to {@code Callable} classes.
 *
 * @see Executor
 * @since 1.5
 * @author Doug Lea
 * @param <V> the result type of method {@code call}
 */
@FunctionalInterface
public interface Callable<V> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    V call() throws Exception;
}
```
Runnable
- Runnable 是用于新建一个thread，想跑一个method 时候，就需要继承Runnable，并实现run方法。
用于没有返回值，也没有check Exception的场景。
- Runnable 是 java.lang package，开始于JDK1.0。

Callable
- Callable 是用于计算一个返回值，或者抛出一个异常的场景。 
- Callable 是java.util.concurrency package, 开始于 JDK 1.5。

Executors 可以实现Runnable 和 Callable的相互转换


Atomic 原子类

原子性：一个操作要么全部成功要么全部失败，不存在只操作成功其中一部分情况。

ava.util.concurrent.atomic

`AtomicInterger` 原理：使用CompareAndSwap　(CAS) + volatile 和 native 方法 保证原子性。