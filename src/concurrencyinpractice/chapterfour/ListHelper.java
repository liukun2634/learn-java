package concurrencyinpractice.chapterfour;

import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ThreadSafe
public class ListHelper<E> {
    //Make list is threadSafe
    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public boolean putIfAbsent(E x) {
        //This may need add lock in each function code block,
        //Because here we use this list lock directly
        //We better use delegate way to do, use object wrap and use object lock -> ImprovedList<E>

        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }
    }
}
