package findMaximizedCapital;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2021/9/8 上午6:50
 */
public class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] pair = new int[n][2];
        boolean speedUp = true;
        for (int i = 0; i < n; i++) {
            pair[i][0] = capital[i];
            pair[i][1] = profits[i];
            if (capital[i] > w) {
                speedUp = false;
                break;
            }
        }

        if (speedUp) {
            Arrays.sort(profits);
            for (int i = 0; i < Math.min(n, k); i++) {
                w += profits[n-i-1];
            }
            return w;
        }
        Arrays.sort(pair, Comparator.comparingInt(a -> a[0]));
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        int idx = 0;
        for (int i = 0; i < k; i++) {
            while (idx < n && pair[idx][0] <= w) {
                queue.add(pair[idx++][1]);
            }
            if (!queue.isEmpty()) w+=queue.poll();
            else break;
        }
        return w;
    }

}
