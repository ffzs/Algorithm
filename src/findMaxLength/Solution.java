package findMaxLength;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/6/3 上午7:31
 */
public class Solution {

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        // [c0, c1]
        int[][] counter = new int[n+1][2];

        for (int i = 0; i < n; i++) {
            counter[i+1][0] = counter[i][0];
            counter[i+1][1] = counter[i][1];
            if (nums[i]==0) counter[i+1][0]++;
            else counter[i+1][1]++;
        }

        int res = 0;
        for (int i = n; i > res; i--) {
            for (int j = 0; j < i-1; j++) {
                if ((counter[i][0] - counter[j][0]) == (counter[i][1]-counter[j][1])) res = Math.max(res, i-j);
            }
        }
        return res;
    }

}
