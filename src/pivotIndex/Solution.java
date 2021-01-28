package pivotIndex;

import java.net.Socket;

/**
 * @author: ffzs
 * @Date: 2021/1/28 上午8:16
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        double leftSum = 0;

        for (int num : nums) sum += num;

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == (sum - nums[i]) / 2d) return i;
            leftSum += nums[i];
        }

        return -1;
    }

}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,7,3,6,5,6};
        System.out.println(solution.pivotIndex(nums));
    }
}
