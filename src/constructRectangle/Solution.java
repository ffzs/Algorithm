package constructRectangle;

/**
 * @author: ffzs
 * @Date: 2021/10/23 上午7:24
 */

public class Solution {

    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while (w < area) {
            if (area % w == 0) {
                return new int[]{area / w, w};
            }
            w --;
        }
        return new int[]{area / w, w};
    }

}
