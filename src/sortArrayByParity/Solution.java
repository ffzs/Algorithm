package sortArrayByParity;

/**
 * @author: ffzs
 * @Date: 2022/4/28 上午8:38
 */
public class Solution {

    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length-1;

        int tmp;
        while (l < r) {
            while (l < r && nums[l] % 2 == 0) ++l;
            while (l < r && nums[r] % 2 == 1) --r;
            if (l >= r) break;
            tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
        return nums;
    }

}
