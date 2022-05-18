package findKthNumber2;

/**
 * @author: ffzs
 * @Date: 2022/5/18 上午8:16
 */
public class Solution {

    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m * n;
        while (l < r) {
            int mid = (l + r) >>> 1, idx = mid / n;
            int cnt = idx * n;
            for (int i = idx + 1; i <= m; i++) {
                cnt += mid / i;
            }
            if (cnt >= k) r = mid;
            else l = mid + 1;
        }

        return l;
    }

}
