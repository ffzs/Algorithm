package isBoomerang;

/**
 * @author: ffzs
 * @Date: 2022/6/8 上午8:27
 */
public class Solution {

    public boolean isBoomerang(int[][] points) {
        int[] p1 = points[0], p2 = points[1], p3 = points[2];
        return (p1[0] != p2[0] || p1[1] != p2[1]) && ((p1[0] - p2[0]) * (p2[1] - p3[1]) != (p2[0] - p3[0]) * (p1[1] - p2[1]));
    }
}
