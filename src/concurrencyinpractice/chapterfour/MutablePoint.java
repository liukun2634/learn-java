package concurrencyinpractice.chapterfour;

import net.jcip.annotations.NotThreadSafe;

//4-5

@NotThreadSafe
public class MutablePoint {
    public int x, y;

    public MutablePoint() { x = 0; y = 0;}

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
