package countTriplets;

/**
 * @author: ffzs
 * @Date: 2021/5/18 上午9:13
 */
public class Solution2 {

    public int countTriplets(int[] arr) {
        int res = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int k = i; k < n; k++) {
                total ^= arr[k];
                if (total == 0) res += k - i;
            }
        }

        return res;
    }

}
