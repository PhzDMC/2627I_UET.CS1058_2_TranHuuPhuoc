package Week7.BT_LapTrinh;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int n = A.length();
        boolean check=true;
        int l=0, r=n-1;
        while (l<=r){
            if(A.charAt(l) != A.charAt(r)){
                System.out.print("No");
                check=false;
                break;
            }
            l++;
            r--;
        }
        if(check){
            System.out.print("Yes");
        }
    }
}
