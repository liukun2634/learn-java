package concurrency.chapterfour;

import net.jcip.annotations.GuardedBy;

//Private Lock is better than Object lock
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock")
    private Widget widget;

    void someMethod() {
        synchronized (myLock) {
            //access or modify widget
        }
    }

    static class Widget{
    }
}


