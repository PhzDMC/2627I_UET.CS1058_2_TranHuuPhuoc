package Week4.BT_LapTrinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class Bai7_CountingSort {
    public static List<Integer> countingSort(List<Integer> arr) {
        List<Integer> countSort = new ArrayList<>(Collections.nCopies(100,0));
        for(Integer i : arr){
            countSort.set(i,countSort.get(i)+1);
        }
        return countSort;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        List<Integer> res = countingSort(arr);
        for(Integer x : arr){
            System.out.print(x+" ");
        }
    }
}
