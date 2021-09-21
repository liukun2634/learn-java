package concurrencyinpractice.chapterfour;

import java.lang.String;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//4-4

//Use deepCopy + return new reference to wrap UnThreadSafe object
//May have performance issue
@ThreadSafe
public class MonitorVehicleTracker {
    @GuardedBy("this")
    private final Map<String, MutablePoint> locations;


    public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        //Make sure the locations cannot be impact, **return a new reference**
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    //Only update location
    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if(loc == null) {
            throw new IllegalArgumentException("No such Id" + id);
        }
        loc.x = x;
        loc.y = y;
    }



    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
        Map<String, MutablePoint> result = new HashMap<>();
        for(String id : m.keySet()) {
            result.put(id, new MutablePoint(m.get(id)));
        }
        //Set unmodifiable Map
        return Collections.unmodifiableMap(result);
    }
}
