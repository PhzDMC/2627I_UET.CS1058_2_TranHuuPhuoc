package Week3.BT_LapTrinh;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueUsingTwoStacks<Item> {
    private Stack<Item> stackInbox = new Stack<Item>();
    private Stack<Item> stackOutbox = new Stack<Item>();
    public void enqueue(Item item) {
        stackInbox.push(item);
    }
    private void shiftStacks() {
        if (stackOutbox.isEmpty()) {
            while (!stackInbox.isEmpty()) {
                stackOutbox.push(stackInbox.pop());
            }
        }
    }
    public Item dequeue() {
        shiftStacks();
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return stackOutbox.pop();
    }
    public Item peek() {
        shiftStacks();
        if (isEmpty()) {
            throw new NoSuchElementException("Queue underflow");
        }
        return stackOutbox.peek();
    }
    public boolean isEmpty() {
        return stackInbox.isEmpty() && stackOutbox.isEmpty();
    }
    public int size() {
        return stackInbox.size() + stackOutbox.size();
    }
}

