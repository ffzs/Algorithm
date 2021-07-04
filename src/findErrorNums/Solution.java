package findErrorNums;

/**
 * @author: ffzs
 * @Date: 2021/7/4 上午10:05
 */
public class Solution {

    public int[] findErrorNums(int[] nums) {
        int[] counter = new int[nums.length];
        for (int num : nums) {
            counter[num - 1]++;
        }
        int[] res = new int[2];
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 2) res[0] = i + 1;
            if (counter[i] == 0) res[1] = i + 1;
        }
        return res;
    }

}
