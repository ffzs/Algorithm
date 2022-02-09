package countKDifference;

/**
 * @author: ffzs
 * @Date: 2022/2/9 上午8:51
 */
public class Solution {

    public int countKDifference(int[] nums, int k) {
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num]++;
        }
        int res = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (i+k>=0 && i+k<=100) {
                res += cnt[i] * cnt[i+k];
            }
        }
        return res;
    }

}
