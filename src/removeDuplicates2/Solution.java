package removeDuplicates2;

/**
 * @author: ffzs
 * @Date: 2021/4/18 上午8:57
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j-1]) nums[j++] = nums[i];
        }
        return j;
    }

}
