package sortColors;

/**
 * @author: ffzs
 * @Date: 2020/10/7 上午9:54
 */
public class Solution {

    public void sortColors(int[] nums) {
        int[] counter = new int[3];
        for (int num : nums) {
            counter[num] ++;
        }
        int idx = 0;
        for (int i = 0; i < counter.length; i++) {
            for (int j = 0; j < counter[i]; j++) {
                nums[idx++] = i;
            }
        }
    }
}
