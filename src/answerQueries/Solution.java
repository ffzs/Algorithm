package answerQueries;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/3/17 上午9:54
 */
public class Solution {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] cums = new int[nums.length];
        cums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cums[i] = cums[i-1] + nums[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] >= cums[cums.length-1]) res[i] = cums.length;
            else res[i] = bSearch(cums, queries[i])+1;
        }
        return res;
    }

    private int bSearch (int[] cums, int k) {
        int l = 0, r = cums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (cums[mid] == k) return mid;
            else if (cums[mid] > k) r = mid;
            else l = mid + 1;
        }
        return l-1;
    }

}
