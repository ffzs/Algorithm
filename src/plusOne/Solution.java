package plusOne;

/**
 * @author: ffzs
 * @Date: 2021/10/21 上午7:13
 */
public class Solution {
    
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            int cur = digits[i] + 1;
            digits[i] = cur % 10;
            if (cur != 10) return digits;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
    
}
