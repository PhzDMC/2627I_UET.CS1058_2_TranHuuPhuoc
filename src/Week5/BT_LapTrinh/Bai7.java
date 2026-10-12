package Week5.BT_LapTrinh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bai7 {
    private static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j) <= pivot) {
                i++;
                Collections.swap(arr, i, j);
            }
        }

        Collections.swap(arr, i + 1, high);
        return i + 1;
    }

    private static int quickselect(List<Integer> arr, int low, int high, int k) {
        if (low <= high) {
            int pi = partition(arr, low, high);

            if (pi == k) {
                return arr.get(pi);
            } else if (pi > k) {
                return quickselect(arr, low, pi - 1, k);
            } else {
                return quickselect(arr, pi + 1, high, k);
            }
        }
        return -1;
    }

    public static int findMedian(List<Integer> arr) {
        return quickselect(arr, 0, arr.size() - 1, arr.size() / 2);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        int median = findMedian(arr);
        System.out.println(median);
    }
}
