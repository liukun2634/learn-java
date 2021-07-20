package concurrencyinpractice.chapterfour;

import net.jcip.annotations.NotThreadSafe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@NotThreadSafe
public class NoSafeListHelper<E> {
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    //WRONG: synchronized should used on list rather than NoSafeListHelper object
    public synchronized boolean putIfAbsent(E x){
        boolean absent = !list.contains(x);
        if(absent) {
            list.add(x);
        }
        return absent;
    }


}
