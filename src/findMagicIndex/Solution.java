package findMagicIndex;

/**
 * @author: ffzs
 * @Date: 2020/7/31 上午8:45
 */
public class Solution {
    public int findMagicIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) return i;
        }
        return -1;
    }
}
