package constructArray;

/**
 * @author: ffzs
 * @Date: 2022/9/8 上午10:25
 */
public class Solution {

    public int[] constructArray(int n, int k) {
        int l = 1, r = n;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (k == 0) {
                if (i % 2 == 0) {
                    while (i < n) res[i++] = r--;
                }
                else while (i < n) res[i++] = l++;
                return res;
            }
            else if (i % 2 == 0) {
                res[i] = l++;
                k -= 1;
            }
            else {
                res[i] = r--;
                k -= 1;
            }
        }
        return res;
    }
}
