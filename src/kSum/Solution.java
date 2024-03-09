package kSum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2024/3/9 下午7:53
 */
public class Solution {
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        long total = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                total += nums[i];
            } else {
                nums[i] = -nums[i];
            }
        }

        Arrays.sort(nums);

        long res = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        pq.offer(new long[]{nums[0], 0});

        for (int j = 2; j <= k; j++) {
            long[] cur = pq.poll();
            long t = cur[0];
            int i = (int)cur[1];
            res = t;
            if (i == n - 1) {
                continue;
            }

            pq.offer(new long[]{t + nums[i + 1], i + 1});
            pq.offer(new long[]{t - nums[i] + nums[i + 1], i + 1});
        }
        return total - res;
    }
}
