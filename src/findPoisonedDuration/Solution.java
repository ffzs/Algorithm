package findPoisonedDuration;

/**
 * @author: ffzs
 * @Date: 2021/11/10 上午7:37
 */
public class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        int res = timeSeries[n-1] - timeSeries[0] + duration;

        for (int i = 1; i < n; i++) {
            if (timeSeries[i-1] + duration < timeSeries[i]) res -= timeSeries[i] -timeSeries[i-1] - duration;
        }
        return res;
    }

}
