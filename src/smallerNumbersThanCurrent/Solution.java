package smallerNumbersThanCurrent;

/**
 * @author: ffzs
 * @Date: 2020/10/26 上午6:16
 */

public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counter = new int[101];
        for (int num : nums) counter[num]++;
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i-1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) res[i] = counter[nums[i]-1];
        }
        return res;
    }

}
