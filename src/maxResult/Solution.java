package maxResult;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2024/2/5 下午10:29
 */
public class Solution {

    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> queue = new LinkedList<>();
        queue.offerLast(0);
        for (int i = 1; i < n; i++) {
            while (queue.peekFirst() < i - k) {
                queue.pollFirst();
            }
            dp[i] = dp[queue.peekFirst()] + nums[i];
            while (!queue.isEmpty() && dp[queue.peekLast()] <= dp[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        return dp[n-1];
    }

}
