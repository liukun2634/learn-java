package concurrency.chapterfour;

import net.jcip.annotations.ThreadSafe;

import java.util.Vector;


//Extend Class to make thread safe for put-if-absent method
@ThreadSafe
public class BetterVector<E> extends Vector<E> {

    //Synchronized make sure this method is thread safe
    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent) {
            add(x);
        }
        return absent;
    }
}
