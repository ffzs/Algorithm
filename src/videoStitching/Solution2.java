package videoStitching;

/**
 * @author: ffzs
 * @Date: 2020/10/24 上午11:29
 */
public class Solution2 {
    public int videoStitching(int[][] clips, int T) {

        int cur = 0, max = 0, count = 0;
        while (cur < T) {
            for (int[] clip : clips) {
                if (clip[0] <= cur) {
                    max = Math.max(clip[1], max);
                }
            }
            count++;
            if (max >= T) return count;
            if (max == cur) return -1;
            cur = max;
        }
        return -1;
    }
}
