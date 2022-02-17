package knightProbability;

/**
 * @author: ffzs
 * @Date: 2022/2/17 上午9:53
 */
public class Solution {

    int[][] dirs = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
    int n, k;
    double[][][] g;
    public double knightProbability(int n, int k, int row, int column) {
        g = new double[n][n][k+1];
        this.n = n;
        this.k = k;
        return helper(row, column, 0);
    }

    private double helper(int x, int y, int times) {
        if (!isValid(x,y)) return 0;
        if (times == k) {
            return 1;
        }
        if (g[x][y][times] != 0) return g[x][y][times];
        double sum = 0;
        for (int[] dir : dirs) {
            sum += helper(x + dir[0], y + dir[1], times + 1);
        }
        return g[x][y][times] = sum / 8;
    }

    private boolean isValid (int x, int y) {
        return x >= 0 && y >= 0 && x < n && y< n;
    }

}
