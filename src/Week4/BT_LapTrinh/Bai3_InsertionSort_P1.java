package Week4.BT_LapTrinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai3_InsertionSort_P1 {
    public static void insertionSort1(int n, List<Integer> arr){
        int key = arr.get(n-1);
        int i = n-2;
        while(i>=0 && arr.get(i)>key){
            arr.set(i+1,arr.get(i));
            i--;
            for(int j=0; j<n; j++){
                System.out.print(arr.get(j)+ " ");
            }
            System.out.println();
        }
        arr.set(i+1,key);
        for(int j=0; j<n; j++){
            System.out.print(arr.get(j)+ " ");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(sc.nextInt());
        }
        insertionSort1(n, arr);
    }
}
