package hIndex3;

/**
 * @author: ffzs
 * @Date: 2023/10/30 上午5:27
 */
public class Solution {

    public int hIndex(int[] citations) {
        int n = citations.length;

        if (n == 0 || citations[n-1] == 0) return 0;

        int l = 0, r = n-1;

        while (l < r) {
            int mid = (l + r) >> 1;
            if (citations[mid] < n-mid) l = mid + 1;
            else r = mid;
        }
        return n - l;
    }

}
