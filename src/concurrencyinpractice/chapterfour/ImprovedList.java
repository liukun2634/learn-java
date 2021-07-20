package concurrencyinpractice.chapterfour;

import net.jcip.annotations.ThreadSafe;

import java.util.List;

@ThreadSafe
public class ImprovedList<E> {
    //Implement List<E> and override all the method then it is good to be used

    //1. only one reference
    private final List<E> list;

    //Delegate
    public ImprovedList(List<E> list) {
        this.list = list;
    }

    //2. Wrap and lock by object
    public synchronized boolean putIfAbsent(E x) {
        boolean contains = list.contains(x);
        if (!contains) {
            list.add(x);
        }
        return !contains;
    }
}
