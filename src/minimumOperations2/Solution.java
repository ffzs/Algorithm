package minimumOperations2;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/2/24 上午6:26
 */
public class Solution {

    public int minimumOperations(int[] nums) {
        int[] cnt = new int[101];
        for (int num : nums) {
            cnt[num] += 1;
        }

        int res = 0;
        for (int i = 1; i < 101; i++) {
            if (cnt[i] != 0) res += 1;
        }
        return res;
    }

}
