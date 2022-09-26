package missingTwo;

/**
 * @author: ffzs
 * @Date: 2022/9/26 上午11:32
 */
public class Solution {

    public int[] missingTwo(int[] nums) {
        int sum = 0, n = nums.length + 2;
        for (int i = 1; i <= n; i++) {
            sum ^= i;
        }
        for (int num : nums) {
            sum ^= num;
        }
        int l = -sum & sum;
        int one = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & l) != 0) one ^= i;
        }
        for (int num : nums) {
            if ((num & l) != 0) one ^= num;
        }
        return new int[]{one, one ^ sum};
    }

}
