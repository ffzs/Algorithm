package equalSubstring;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/2/5 上午8:40
 */
public class Solution {

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            tmp[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int res = 0, sum = 0;
        int left = 0, right = 0;
        while (right < n) {
            if (sum + tmp[right] <= maxCost) {
                sum += tmp[right];
                res = Math.max(res, right - left + 1);
                right ++;
            }
            else {
                sum -= tmp[left++];
            }
        }

        return res;
    }

}

class Test{
    public static void main(String[] args) {
        String s = "abcd";
        String t = "cdef";
        Solution solution = new Solution();
        System.out.println(solution.equalSubstring(s, t, 3));
    }
}
