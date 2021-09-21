package thinkinginjava.holding;

//Adding groups of elements to Collection objects

import java.lang.String;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {

        //Arrays.asList return Collection
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        //Collection.addAll(collection)
        Integer[] moreInts = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));

        //Collections.addAll(collection, ...  )
        //Runs significantly faster, but you can't construct a Collection this way
        Collections.addAll(collection, 11,12,13,14,15);

        /* !Arrays.asList return list cannot change the length */
        List<Integer> list = Arrays.asList(16,17,18,19,20);
        list.set(1,2); //OK -- modify an element
        System.out.println(list);
        list.add(21); //Runtime error: UnsupportedOperationException
                      // because the underlying array cannot be resized
        System.out.println(list);
    }
}
