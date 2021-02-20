package findShortestSubArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/2/20 上午8:31
 */
public class Solution2 {


    public int findShortestSubArray(int[] nums) {

        int[] tmp = new int[50000];
        int[] left = new int[50000];
        int[] right = new int[50000];
        for (int i = 0; i < left.length; i++) {
            left[i] = -1;
            right[i] = -1;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (left[cur] == -1) left[cur] = i;
            right[cur] = i;
            tmp[cur] ++;
            max = Math.max(max, tmp[cur]);
        }
        int res = nums.length;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == max) {
                res = Math.min(res, right[i] - left[i] + 1);
            }
        }
        return res;
    }
}
