package Week5.BT_LapTrinh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bai5 {
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here
        int n = arr.size();
        int pivot=arr.get(0);
        Collections.swap(arr,0,n-1);
        int k = 0;
        for(int i=0; i<n-1; i++){
            if(arr.get(i) < pivot){
                Collections.swap(arr,k,i);
                k++;
            }
        }
        Collections.swap(arr, k, n-1);
        return arr;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        quickSort(arr);
        for(int j=0; j<n; j++){
            System.out.print(arr.get(j)+" ");
        }
    }
}
