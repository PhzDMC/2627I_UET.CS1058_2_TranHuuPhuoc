package Week5.BT_LapTrinh;

import java.util.NoSuchElementException;

public class Bai8 {
    private int[] arr;
    private int size;
    private int capacity;
    public Bai8(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }
    public void insert(int value) {
        if (size >= capacity) {
            throw new IllegalStateException("Hàng đợi đã đầy");
        }
        arr[size] = value;
        size++;
    }
    public int deleteMin() {
        if (size == 0) {
            throw new NoSuchElementException("Hàng đợi rỗng");
        }
        int minIndex = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        int minValue = arr[minIndex];
        arr[minIndex] = arr[size - 1];
        size--;
        return minValue;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public static void main(String[] args) {
        Bai8 pq = new Bai8(11);

        pq.insert(3);
        pq.insert(1);
        pq.insert(1);
        pq.insert(20);
        pq.insert(7);
        System.out.println("deleteMin(): " + pq.deleteMin());
    }
}
