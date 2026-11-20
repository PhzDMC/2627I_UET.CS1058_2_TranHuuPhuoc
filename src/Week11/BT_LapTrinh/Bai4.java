package Week11.BT_LapTrinh;
import java.util.*;

public class Bai4 {
    static int pairs(int k, List<Integer> arr) {
        Set<Integer> set = new HashSet<>(arr);
        int count = 0;
        for(int i=0; i<arr.size(); i++){
            if(set.contains(arr.get(i)+k)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        int ans = pairs(k,arr);
        System.out.println(ans);
    }
}
