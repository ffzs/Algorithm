package minMoves;


/**
 * @author: ffzs
 * @Date: 2021/10/20 上午7:11
 */
public class Solution {

    public int minMoves(int[] nums) {
        int min = nums[0], sum = 0;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            sum += num - min;
        }
        return sum;
    }

}
