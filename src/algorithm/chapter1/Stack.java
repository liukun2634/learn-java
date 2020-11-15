package algorithm.chapter1;

//Stack implement

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() {return N;}

    public void push(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        //To be implementation
        throw new UnsupportedOperationException();
    }
}
