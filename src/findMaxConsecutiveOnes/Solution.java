package findMaxConsecutiveOnes;

/**
 * @author: ffzs
 * @Date: 2021/2/15 上午8:48
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, res = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                if (count > res) res = count;
            }
            else {
                count = 0;
            }
        }
        return res;
    }
}
