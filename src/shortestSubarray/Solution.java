package shortestSubarray;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2022/10/26 下午12:42
 */
public class Solution {

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] numSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            numSum[i + 1] = numSum[i] + nums[i];
        }
        int res = Integer.MAX_VALUE;
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            long cur = numSum[i];
            while (!dq.isEmpty() && numSum[dq.peekLast()] <= cur) dq.removeLast();
            while (!dq.isEmpty() && cur - numSum[dq.peekFirst()] >= k) {
                res = Math.min(res, i - dq.pollFirst());
            }
            dq.addLast(i);
        }
        return res == Integer.MAX_VALUE ? -1:res;
    }

}
