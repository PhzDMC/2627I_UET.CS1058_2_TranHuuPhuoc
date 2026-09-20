package Week2.AlgorithmAnalysis.bai_1_4_14;

import edu.princeton.cs.algs4.BinarySearch;
import java.util.Arrays;

public class FourSum {
    public static int count(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long target = -((long) a[i] + a[j] + a[k]); // Ép kiểu long tránh tràn số
                    int l = BinarySearch.indexOf(a, (int) target);
                    if (l > k && (long) a[l] == target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
