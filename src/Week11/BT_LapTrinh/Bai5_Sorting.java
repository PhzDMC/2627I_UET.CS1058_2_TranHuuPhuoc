package Week11.BT_LapTrinh;
import java.util.*;
/*
- arr.sort(null): O(nlogn)
- brr.sort(null): O(mlogm)
- Hai vòng lặp while: O(m)
Vì n <= m => Độ phức tạp là O(mlogm)
 */
public class Bai5_Sorting {
    static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        arr.sort(null);
        brr.sort(null);
        List<Integer> list = new ArrayList<>();
        int i=0, j=0;
        while(i<arr.size() && j<brr.size()){
            if(arr.get(i).equals(brr.get(j))){
                i++;
            }
            else{
                if(list.isEmpty() || !list.get(list.size()-1).equals(brr.get(j))){
                    list.add(brr.get(j));
                }
            }
            j++;
        }
        while(j<brr.size()){
            if(list.isEmpty() || !list.get(list.size()-1).equals(brr.get(j))){
                list.add(brr.get(j));
            }
            j++;
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int m = sc.nextInt();
        List<Integer> brr = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            brr.add(sc.nextInt());
        }
        List<Integer> ans = missingNumbers(arr, brr);
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
    }
}
