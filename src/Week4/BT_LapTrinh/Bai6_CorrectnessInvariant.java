package Week4.BT_LapTrinh;

import java.util.Scanner;

public class Bai6_CorrectnessInvariant {
    public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            // while j > 0 && A[j] > value
            // Loop Invariant fix: Đổi 'j > 0' thành 'j >= 0' để so sánh với cả phần tử A[0].
            // Nếu j > 0, vòng lặp dừng sớm và không thể chèn giá trị nhỏ nhất về vị trí 0.
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }
        printArray(A);
    }
    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}
