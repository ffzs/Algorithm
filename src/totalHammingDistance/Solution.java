package totalHammingDistance;

/**
 * @author: ffzs
 * @Date: 2021/5/28 上午7:31
 */
public class Solution {

    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < 30; i++) {
            int one = 0;
            for (int num : nums) {
                one += (num >> i) & 1;
            }
            res += one * (n - one);
        }
        return res;
    }

}
