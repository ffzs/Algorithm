package shortestPathAllKeys;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2022/11/10 下午1:40
 */
public class Solution {
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int inf = Integer.MAX_VALUE >> 1;
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        char[][] g = new char[m][n];
        int sx = 0, sy = 0;
        int[] keys = new int[26];
        int keyCnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = grid[i].charAt(j);
                if (g[i][j] == '@') {
                    sx = i;
                    sy = j;
                    g[i][j] = '.';
                }
                else if (g[i][j] >= 'a' && g[i][j] <= 'z') {
                    keys[g[i][j] - 'a'] = keyCnt++;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int[][][] dist = new int[m][n][1 << keyCnt];
        int full = (1 << keyCnt) - 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], inf);
            }
        }
        queue.offer(new int[]{sx, sy, 0});
        dist[sx][sy][0] = 0;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], mask = cur[2], step = dist[x][y][mask];
            for (int[] dir : directions) {
                int xx = x + dir[0], yy = y + dir[1];
                if (xx < 0 || yy < 0 || xx >= m || yy >= n || g[xx][yy] == '#') continue;
                char c = g[xx][yy];
                if (c >= 'A' && c <= 'Z' && ((mask >> keys[c - 'A']) & 1) == 0) continue;
                int nMask = mask;
                if (c >= 'a' && c <= 'z') nMask |= (1 << keys[c - 'a']);
                if (nMask == full) return step + 1;
                if (step + 1 >= dist[xx][yy][nMask]) continue;
                dist[xx][yy][nMask] = step + 1;
                queue.offer(new int[] {xx, yy, nMask});
            }
        }
        return -1;
    }

}
