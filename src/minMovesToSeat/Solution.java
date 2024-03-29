package minMovesToSeat;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/12/31 下午12:02
 */
public class Solution {

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(seats[i] - students[i]);
        }
        return res;
    }

}
