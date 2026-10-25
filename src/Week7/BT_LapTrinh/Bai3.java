package Week7.BT_LapTrinh;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        Queue<Integer> pQueue = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            pQueue.add(sc.nextInt());
        }
        int ans=0;
        while(pQueue.peek()<k && pQueue.size()>1){
            int m1=pQueue.poll();
            int m2=pQueue.poll();
            pQueue.add(m1+2*m2);
            ans++;

        }
        if(pQueue.size()==1 && pQueue.peek()<k){
            System.out.println(-1);
        }
        else{
            System.out.println(ans);
        }
    }
}
