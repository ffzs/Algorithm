package carPooling;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2023/12/2 上午11:43
 */
public class Solution {

    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        Arrays.sort(trips, (a,b)->a[1]-b[1]);

        int total = 0;
        for (int[] trip : trips) {
            int from = trip[1], to = trip[2], num = trip[0];

            while (!pq.isEmpty() && pq.peek()[0] <= from) {
                total -= pq.poll()[1];
            }

            total += num;
            if (total > capacity) return false;
            pq.offer(new int[]{to, num});
        }

        return true;
    }

    public boolean carPooling2(int[][] trips, int capacity) {
        int inf = 0;
        for (int[] trip : trips) {
            inf = Math.max(inf, trip[2]);
        }

        int[] cnt = new int[inf + 1];
        for (int[] trip : trips) {
            cnt[trip[1]] += trip[0];
            cnt[trip[2]] -= trip[0];
        }

        int total = 0;

        for (int i = 0; i <= inf; i++) {
            total += cnt[i];
            if (total > capacity) return false;
        }

        return true;
    }


}
