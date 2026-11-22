package Week11.BT_LapTrinh;
import java.util.*;
/*
K = max_val - min_val + 1
- Tìm min_val và max_val: Duyệt qua toàn bộ brr mất O(m)
- Khởi tạo mảng counting_sort: Cấp phát và gán giá trị 0 mặc định cho mảng kích thước K mất O(K)
- Đếm tần suất trên brr: O(m)
- Trừ tần suất trên arr: O(n)
- Tạo danh sách kết quả list: O(K)
Vì K<=101 và n<=m => Độ phức tạp O(m)
 */
public class Bai5_CountingSort {
    static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        int min_val = brr.get(0);
        int max_val = brr.get(0);
        for(int x : brr){
            if(x<min_val){
                min_val=x;
            }
            if(x>max_val){
                max_val=x;
            }
        }
        int[] counting_sort = new int[max_val-min_val+1];
        for(int i=0;i<brr.size();i++){
            counting_sort[brr.get(i)-min_val]++;
        }
        for(int j=0; j<arr.size(); j++){
            counting_sort[arr.get(j)-min_val]--;
        }
        List<Integer> list = new ArrayList<>();
        for(int k=0; k<counting_sort.length; k++){
            if(counting_sort[k]>0){
                list.add(k+min_val);
            }
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
