package numsGame;

import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2024/2/1 下午9:38
 */
public class Solution {
    private static final int MOD = (int)1e9 + 7;
    public int[] numsGame(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> b-a);
        PriorityQueue<Integer> right = new PriorityQueue<>();

        long lSum = 0, rSum = 0;

        for (int i = 0; i < n; i++) {
            int b = nums[i] - i;
            if (i % 2 == 0) {
                if (! left.isEmpty() && b < left.peek()) {
                    lSum -= left.peek() - b;
                    left.offer(b);
                    b = left.poll();
                }
                rSum += b;
                right.offer(b);
                res[i] = (int) ((rSum - right.peek() - lSum) % MOD);
            } else {
                if ( b > right.peek()) {
                    rSum += b - right.peek();
                    right.offer(b);
                    b = right.poll();
                }
                lSum += b;
                left.offer(b);
                res[i] = (int) ((rSum - lSum) % MOD);
            }
        }
        return res;

    }

}
