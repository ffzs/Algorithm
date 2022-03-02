package nearestPalindromic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2022/3/2 上午8:05
 */
public class Solution {

    public String nearestPalindromic(String n) {
        long res = -1, num = Long.parseLong(n);
        for (long it : getNums(n)) {
            if (it != num) {
                if (res == -1) res = it;
                else if (Math.abs(it - num) < Math.abs(res- num)) res = it;
                else if (Math.abs(it - num) == Math.abs(res - num) && it < res) res = it;
            }
        }
        return String.valueOf(res);
    }


    private long[] getNums (String s) {
        int n = s.length();
        long[] nums = new long[5];
        nums[0] = (long) Math.pow(10, n - 1) - 1;
        nums[1] = (long) Math.pow(10, n) + 1;
        long pre = Long.parseLong(s.substring(0, (n + 1) >> 1));
        int j = 2;
        for (long i = pre - 1; i <= pre + 1; ++i) {
            String cur = String.valueOf(i);
            StringBuilder sb = new StringBuilder().append(cur);
            sb.append(new StringBuilder(cur).reverse().substring(n & 1));
            nums[j++] = Long.parseLong(sb.toString());
        }
        return nums;
    }

}
