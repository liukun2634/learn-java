package algorithm.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.item = null;
        // Take care for empty case
        if (isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        N++; //Add size;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        //should set oldFirst.next = null to for garbage collection?
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }




    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Item> action) {

    }

    @Override
    public Spliterator<Item> spliterator() {
        return null;
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if(!item.equals("-")) {
                q.enqueue(item);
            }
            else if (!q.isEmpty()) {
                StdOut.print(q.dequeue() + " ");
            }
        }
        StdOut.println("(" + q.size() + "left on queue)");
    }
}
