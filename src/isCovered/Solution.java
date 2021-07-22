package isCovered;

/**
 * @author: ffzs
 * @Date: 2021/7/23 上午6:53
 */
public class Solution {

    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] tmp = new boolean[right - left + 1];

        for (int[] range : ranges) {
            for (int i = Math.max(range[0], left); i <= Math.min(range[1], right); i++) {
                tmp[i-left] = true;
            }
        }

        for (boolean b : tmp) {
            if (!b) return b;
        }
        return true;
    }

}
