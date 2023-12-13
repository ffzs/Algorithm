package makeSmallestPalindrome;

/**
 * @author: ffzs
 * @Date: 2023/12/13 上午10:05
 */
public class Solution {

    public String makeSmallestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = cs.length-1;
        while (l < r) {
            if (cs[l] != cs[r]) {
                if (cs[l] < cs[r]) cs[r] = cs[l];
                else cs[l] = cs[r];
            }
            l++;
            r--;
        }
        return new String(cs);
    }

}
