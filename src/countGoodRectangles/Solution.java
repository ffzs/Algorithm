package countGoodRectangles;

/**
 * @author: ffzs
 * @Date: 2022/2/4 上午6:29
 */
public class Solution {

    public int countGoodRectangles(int[][] rectangles) {
        int max = 0, res = 0;
        for (int[] re : rectangles) {
            int cur = Math.min(re[0], re[1]);
            if (cur > max) max = cur;
        }

        for (int[] re : rectangles) {
            if (re[0] >= max && re[1] >= max) res++;
        }

        return res;
    }

}
