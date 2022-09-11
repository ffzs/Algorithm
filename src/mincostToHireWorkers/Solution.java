package mincostToHireWorkers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2022/9/11 下午3:03
 *
 * t = wage / quality
 * totalw = totalq * MAX(t);
 *
 */
public class Solution {

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double[][] tmp = new double[n][2];
        for (int i = 0; i < n; i++) {
            tmp[i][0] = (double) wage[i]/quality[i];
            tmp[i][1] = quality[i];
        }

        Arrays.sort(tmp, Comparator.comparingDouble(a -> a[0]));

        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->(int)b[1] - (int)a[1]);

        double totalQ = 0.0, res = 1e9;
        for (int i = 0; i < k-1; i++) {
            totalQ += tmp[i][1];
            pq.offer(tmp[i]);
        }

        for (int i = k-1; i < n; i++) {
            totalQ += tmp[i][1];
            pq.offer(tmp[i]);
            double totalW = tmp[i][0] * totalQ;
            res = Math.min(res, totalW);
            totalQ -= pq.poll()[1];
        }

        return res;
    }

}
