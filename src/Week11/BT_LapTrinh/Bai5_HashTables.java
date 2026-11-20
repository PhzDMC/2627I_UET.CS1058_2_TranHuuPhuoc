package Week11.BT_LapTrinh;
import java.util.*;
/*
- Vòng lặp duyệt brr: chạy m lần,mỗi lần gọi brr.get(i) O(1), hashMap.merge() O(1) -> O(m)
- Vòng lặp duyệt arr: O(n)
- Vòng lặp duyệt hashMap.entrySet(): duyệt k phần tử phân biệt -> O(k)
- Sắp xếp danh sách kết quả list.sort(null): O(1) do max(brr) - min(brr) <= 100
Vì k<=m => Độ phức tạp : O(m+n)
*/
public class Bai5_HashTables {
    static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i<brr.size(); i++){
            hashMap.merge(brr.get(i), 1, Integer::sum);
        }
        for(int j=0; j<arr.size(); j++){
            hashMap.merge(arr.get(j), -1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(value>0){
                list.add(key);
            }
        }
        list.sort(null);
        return list;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            arr.add(sc.nextInt());
        }
        int m = sc.nextInt();
        List<Integer> brr = new ArrayList<>();
        for(int j=0; j<m; j++){
            brr.add(sc.nextInt());
        }
        List<Integer> ans = missingNumbers(arr,brr);
        for(Integer x : ans){
            System.out.print(x+" ");
        }

    }
}
