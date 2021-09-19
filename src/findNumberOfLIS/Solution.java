package findNumberOfLIS;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2021/9/20 上午6:58
 */

public class Solution {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] end = new int[n];
        TreeMap[] dp = new TreeMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new TreeMap<Integer, Integer>();
        }

        end[0] = nums[0];
        dp[0].put(end[0], 1);

        int size = 1, max = 1;

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            int idx = binarySearch(end, size, num);
            idx++;
            if (idx == size) size ++;
            end[idx] = num;

            max = Math.max(max, idx + 1);
            var firstEntry = dp[idx].firstEntry();
            if (idx == 0) {
                dp[idx].put(num, (firstEntry != null? (int)firstEntry.getValue():0) + 1);
            }else {
                int preCount;
                Map.Entry<Integer, Integer> entry = dp[idx-1].ceilingEntry(num);
                preCount = (int)dp[idx-1].firstEntry().getValue() -(entry != null? entry.getValue():0);
                dp[idx].put(num, preCount + (firstEntry != null? (int)firstEntry.getValue():0));
            }
        }
        return (int)dp[max-1].firstEntry().getValue();
    }

    private static int binarySearch(int[] arr, int n, int target) {
        int l = 0, r = n - 1, idx = -1;
        while (l <= r) {
            int m =(l+r)>>>1;
            if (arr[m] < target) {
                idx = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return idx;
    }

}
