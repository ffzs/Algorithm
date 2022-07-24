package distanceBetweenBusStops;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/7/24 下午12:20
 */
public class Solution {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (destination < start) return distanceBetweenBusStops(distance, destination, start);
        int n = distance.length;
        int[] total = new int[n+1];

        for (int i = 1; i <= n; i++) {
            total[i] = total[i-1] + distance[i-1];
        }
        int dis = total[destination] - total[start];
        return Math.min(dis, total[n] - dis);
    }

}
