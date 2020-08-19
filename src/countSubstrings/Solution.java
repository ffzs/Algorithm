package countSubstrings;

/**
 * @author: ffzs
 * @Date: 2020/8/19 上午8:08
 */
public class Solution {
    public int countSubstrings(String s) {
        char[] seq = s.toCharArray();
        int n = seq.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int count = 0, left, right;

        for (int i = 1; i < n-1; ++i) {
                // 奇数
            left = right = i;
            while (left >= 0 && right<n && seq[left--] == seq[right++]) {
                count++;
            }
            // 偶数
            left = i;
            right = i+1;
            while (left >= 0 && right<n && seq[left--] == seq[right++]) {
                count++;
            }
        }
        return count;
    }
}
