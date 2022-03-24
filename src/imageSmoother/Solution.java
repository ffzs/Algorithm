package imageSmoother;

/**
 * @author: ffzs
 * @Date: 2022/3/24 上午8:24
 */
public class Solution {
    int[][] dirs = {{1,1}, {-1,1}, {1,-1}, {-1,-1}, {1,0}, {0,1}, {-1,0}, {0,-1}, {0,0}};
    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;

        int[][] res = new int[m][n];
        int tmp, cnt;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tmp = 0;
                cnt = 0;
                for (int[] dir : dirs) {
                    int x = dir[0] + i, y = dir[1] + j;
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        ++cnt;
                        tmp += img[x][y];
                    }
                }
                res[i][j] = tmp / cnt;
            }
        }
        return res;
    }

}
