package concurrencyinpractice.chapterfour;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;


/* PersonSet is a threadSafe Class
   But HashSet is not a threadSafe, we keep sychronized in PersonSet
 */
@ThreadSafe
public class PersonSet {
    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<>();

    public synchronized void addPerson(Person p) {
        mySet.add(p);
    }

    public synchronized boolean containsPerson(Person p) {
        return mySet.contains(p);
    }


    //We should make Person is also an ThreadSafe Class
    static class Person {
    }
}


