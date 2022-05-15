package largestTriangleArea;

/**
 * @author: ffzs
 * @Date: 2022/5/15 上午8:22
 */
public class Solution {

    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double s = area(points[i], points[j], points[k]);
                    if (s > res) res = s;
                }
            }
        }
        return res;
    }

    private double area(int[] P, int[] Q, int[] R) {
        return 0.5 * Math.abs(P[0]*Q[1] + Q[0]*R[1] + R[0]*P[1]
                -P[1]*Q[0] - Q[1]*R[0] - R[1]*P[0]);
    }

}
