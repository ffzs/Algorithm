package findKOr;

/**
 * @author: ffzs
 * @Date: 2024/3/6 下午8:02
 */
public class Solution {

    public int findKOr(int[] nums, int k) {
        int[] cnt = new int[32];
        for (int num : nums) {
            String s = Integer.toBinaryString(num);
            for (int i = s.length() - 1; i >= 0; i--) {
                cnt[s.length() - i - 1] += s.charAt(i) - '0';
            }
        }

        int res = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] >= k) {
                res += Math.pow(2, i);
            }
        }
        return res;
    }

}
