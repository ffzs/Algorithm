package floodFill;

/**
 * @author: ffzs
 * @Date: 2020/8/16 上午7:23
 */
public class Solution {

//    boolean[][] step;
    int[][] image;
    int n, m, newColor, oldColor;
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        n = image.length;
        if(n == 0) return image;
        m = image[0].length;
//        step = new boolean[n][m];
        this.image = image;
        this.newColor = newColor;
        oldColor = image[sr][sc];
        dfs(sr,sc);
        return image;
    }

    private void dfs (int i, int j) {
//        if (!step[i][j]) {
//            step[i][j] = true;
            image[i][j] = newColor;

            for (int[] dir : directions) {
                int ii = dir[0] + i;
                int jj = dir[1] + j;
                if(isValid(ii,jj) && image[ii][jj] == oldColor) {
                    dfs(ii,jj);
                }
            }
//        }
    }

    private boolean isValid (int i, int j) {
        return i>=0 && i<n && j>=0 && j<m;
    }
}
