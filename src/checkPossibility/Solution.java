package checkPossibility;

/**
 * @author: ffzs
 * @Date: 2021/2/7 上午8:22
 */
public class Solution {

    public boolean checkPossibility(int[] nums) {
        int count = 1;
        int preIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[preIndex]) {
                if (preIndex == 0 || nums[i] >= nums[preIndex - 1]) preIndex = i;
                count --;
            }
            else preIndex = i;
            if (count < 0) return false;
        }
        return true;
    }

}
