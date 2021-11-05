package missingNumber;

/**
 * @author: ffzs
 * @Date: 2021/11/6 上午7:31
 */
public class Solution {

    public int missingNumber(int[] nums) {
        boolean[] step = new boolean[nums.length + 1];
        for (int num : nums) {
            step[num] = true;
        }

        for (int i = 0; i < step.length; i++) {
            if (!step[i]) return i;
        }
        return 0;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int total = (n + 1) * n / 2;
        int sum = 0;
        for (int num : nums) sum += num;
        return total - sum;
    }

}
