package hIndex;

import java.sql.Array;
import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/7/11 上午7:28
 */
public class Solution {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) return n - i;
        }
        return 0;
    }

    public int hIndex3(int[] citations) {
        int n = citations.length;

        if (n == 0 || citations[n - 1] == 0) return 0;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (citations[mid] < n-mid) l = mid +1;
            else r = mid;
        }

        return n-l;
    }

    public int hIndex2(int[] citations) {

        int n = citations.length;
        int[] counter = new int[n + 1];
        for (int citation : citations) {
            if (citation > n) counter[n]++;
            else counter[citation]++;
        }

        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += counter[i];
            if (sum >= i) return i;
        }

        return 0;
    }
}


