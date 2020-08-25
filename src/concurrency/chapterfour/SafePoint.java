package concurrency.chapterfour;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

//Two variable, and have relationship
@ThreadSafe
public class SafePoint {
    @GuardedBy("this")
    private int x, y;

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private SafePoint(int a[]) {
        this(a[0], a[1]);
    }

    //Because we can only use get return array of p value
    public SafePoint(SafePoint p) {
        this(p.get());
    }

    //!Important
    //Use array to return x, y at same time, otherwise we cannot getX and getY
    public synchronized int[] get() {
        return new int[] {x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
