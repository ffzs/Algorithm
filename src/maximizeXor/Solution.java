package maximizeXor;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/5/23 上午7:13
 */
public class Solution {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];

        Arrays.sort(nums);
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) nums[n++] = nums[i];
        }


        int max = -1;
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][1], aim = queries[i][0];
            for (int j = 0; j < n; j++) {
                if (nums[j] <= idx) max = Math.max(max, aim^nums[j]);
            }
            res[i] = max;
            max = -1;
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {5,2,4,6,6,3};
        int[][] queries = {{12,4}, {8,1}, {6,3}};
        Solution2 s = new Solution2();

        System.out.println(Arrays.toString(s.maximizeXor(nums, queries)));
    }
}
