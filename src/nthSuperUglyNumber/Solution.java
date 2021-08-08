package nthSuperUglyNumber;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/8/9 上午6:50
 */
public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();

        visited.add(1L);
        pq.offer(1L);

        int res = 0;
        for (int i = 0; i < n; i++) {
            long cur = pq.poll();
            res = (int) cur;
            for (int prime : primes) {
                long it = cur * prime;
                if (visited.add(it)) pq.offer(it);
            }
        }
        return res;
    }


    public int nthSuperUglyNumber2(int n, int[] primes) {
        int len = primes.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int[] index = new int[len];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                min = Math.min(primes[j] * dp[index[j]], min);
            }
            dp[i] = min;

            for (int j = 0; j < len; j++) {
                if (min == primes[j] * dp[index[j]]) index[j]++;
            }
        }
        return dp[n-1];
    }

}
