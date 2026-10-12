package Week5.BT_LapTrinh;

import edu.princeton.cs.algs4.In;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai1 {
    public static int introTutorial(int V, List<Integer> arr) {
        int left=0,right= arr.size()-1;
        while (left<=right){
            int mid = left +(right-left)/2;
            if(arr.get(mid)==V){
                return mid;
            }
            else if(arr.get(mid)<V){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        int index=introTutorial(V,arr);
        System.out.println(index);
    }
}
