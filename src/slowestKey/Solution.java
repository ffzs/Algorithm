package slowestKey;

/**
 * @author: ffzs
 * @Date: 2022/1/9 上午8:00
 */
public class Solution {

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int idx = 0, max = releaseTimes[0];
        int n = releaseTimes.length;

        for (int i = 1; i < n; i++) {
            int time = releaseTimes[i] - releaseTimes[i-1];
            if (time > max) {
                max = time;
                idx = i;
            }
            else if (time == max && keysPressed.charAt(i) > keysPressed.charAt(idx))  idx = i;
        }
        return keysPressed.charAt(idx);
    }

}
