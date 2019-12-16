package holding;

import java.util.Iterator;

public class IterableClass implements Iterable<String>{
    protected String[] words = ("And that is how we know the Earth to be banana-shape").split(" ");

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        }; // semi-colon is expected
    }


    public static void main(String[] args) {
        //IterableClass.iterator() work
        for(String s: new IterableClass()) {
            System.out.println(s + " ");
        }
    }
}
