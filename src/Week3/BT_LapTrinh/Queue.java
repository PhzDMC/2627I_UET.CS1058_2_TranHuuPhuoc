package Week3.BT_LapTrinh;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int n;
    private class Node {
        private Item item;
        private Node next;
    }
    public Queue(){
        first = null;
        last = null;
        n = 0;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public int size(){
        return n;
    }
    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item=item;
        last.next=null;
        if (isEmpty()){
            first=last;
        }
        else{
            oldlast.next=last;
        }
        n++;
    }
    public Item dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue underflow");
        }
        Item item = first.item;
        first=first.next;
        n--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }
    public Iterator<Item> iterator(){
        return new LinkedIterator();
    }
    private class LinkedIterator implements Iterator<Item>{
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
        public Item next(){
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
