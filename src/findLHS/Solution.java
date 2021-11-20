package findLHS;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/11/20 上午7:27
 */
public class Solution {

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int pre = nums[0], preCnt = 0, cnt = 1;
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i-1]) cnt++;
            else {
                if (nums[i-1] - pre == 1) res = Math.max(cnt + preCnt, res);
                pre = nums[i-1];
                preCnt = cnt;
                cnt = 1;
            }
        }
        if (nums[n-1] - pre == 1) res = Math.max(cnt + preCnt, res);
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2};
        System.out.println(s.findLHS(nums));
    }
}
