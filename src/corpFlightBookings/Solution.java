package corpFlightBookings;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/8/31 上午6:47
 */

public class Solution {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] counter = new int[n];
        for (int[] booking : bookings) {
            int s = booking[0], e = booking[1], num = booking[2];
            for (int i = s - 1; i < e; i++) {
                counter[i] += num;
            }
        }
        return counter;
    }

    public int[] corpFlightBookings2(int[][] bookings, int n) {
        int[] counter = new int[n];
        for (int[] booking : bookings) {
            int s = booking[0], e = booking[1], num = booking[2];
            counter[s-1] += num;
            if (e < n) counter[e] -= num;
        }

        for (int i = 1; i < n; i++) {
            counter[i] += counter[i-1];
        }
        return counter;
    }
}
