package dominantIndex;

/**
 * @author: ffzs
 * @Date: 2022/1/13 上午7:37
 */
public class Solution {

    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE, next = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > max) {
                idx = i;
                next = max;
                max = num;
            }
            else if (num > next) next = num;
        }

        return max >= next * 2 ? idx: -1;
    }

}
