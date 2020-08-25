package concurrency.chapterfour;

import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class PublishingVehicleTracker {
    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiedMap;

    public PublishingVehicleTracker(Map<String, SafePoint> points) {
        this.locations = new ConcurrentHashMap<>(points);
        this.unmodifiedMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiedMap;
    }

    //Return SafePoint, this class is threadSafe, delegate
    public SafePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocation(String id, int x, int y) {
        if (locations.containsKey(id)) {
            throw new IllegalArgumentException("invalid vehicle :" + id);
        }
        locations.get(id).set(x, y);

        //method two
//        if(locations.replace(id, new SafePoint(x, y)) == null) {
//            throw new IllegalArgumentException("invalid vehicle :" + id);
//        }
    }


}
