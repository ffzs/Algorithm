package alternatingSubarray;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2024/1/23 下午9:54
 */
public class Solution {

    public int alternatingSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 2) return 2;
        int[] arr = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            arr[i] = nums[i+1] - nums[i];
        }
        int res = -1;
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] == 1) {
                int cnt = 2;
                int j = i + 1;
                while (j < n-1 && arr[j] + arr[j-1] == 0) {
                    j++;
                    cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }

}
