package decrypt;

/**
 * @author: ffzs
 * @Date: 2022/9/24 下午3:30
 */
public class Solution {

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) return res;
        else if (k > 0) {
            int sum = 0;
            for (int j = 1; j <= k; j++) {
                sum += code[j];
            }
            res[0] = sum;
            for (int i = 1; i < n; i++) {
                sum = sum + code[(i + k) % n] - code[i];
                res[i] = sum;
            }
        }
        else {
            int sum = 0;
            for (int j = n + k; j < n; j++) {
                sum += code[j];
            }
            res[0] = sum;
            for (int i = 1; i < n; i++) {
                sum = sum - code[(n + i - 1 + k) % n] + code[i-1];
                res[i] = sum;
            }
        }
        return res;
    }

}
