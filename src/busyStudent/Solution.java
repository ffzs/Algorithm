package busyStudent;

/**
 * @author: ffzs
 * @Date: 2022/8/19 上午9:56
 */
public class Solution {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length, res = 0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) res += 1;
        }
        return res;
    }

}
