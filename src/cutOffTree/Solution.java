package cutOffTree;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/5/23 上午9:01
 */
public class Solution {

    int res = Integer.MAX_VALUE;
    int m, n;
    int[][] tmp;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int cutOffTree(List<List<Integer>> forest) {
        if (forest.get(0).get(0) == 0) return -1;
        m = forest.size();
        n = forest.get(0).size();
        tmp = new int[m][n];
        int[][] tmp2 = new int[m * n][2];
        int t = 0;
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                int cur = forest.get(i).get(j);
                if (cur != 0) {
                    tmp[i][j] = cur;
                    if (cur > 1) tmp2[t++] = new int[]{i,j};
                }
            }
        }

        int[][] trees = Arrays.copyOf(tmp2, t);
        Arrays.sort(trees, (a, b) -> tmp[a[0]][a[1]] - tmp[b[0]][b[1]]);

        int x = 0, y = 0, res = 0;
        for (int[] tree : trees) {
            int step = bfs(x, y, tree[0], tree[1]);
            if (step == -1) return -1;
            res += step;
            x = tree[0];
            y = tree[1];
        }
        return res;
    }

    private int bfs (int sx, int sy, int ex, int ey) {
        if (sx == ex && sy == ey) return 0;

        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                for (int[] dir : directions) {
                    int xx = x + dir[0];
                    int yy = y + dir[1];
                    if (isValid(xx, yy) && !visited[xx][yy] && tmp[xx][yy] != 0) {
                        if (xx == ex && yy == ey) return step;
                        queue.offer(new int[]{xx, yy});
                        visited[xx][yy] = true;
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid (int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

}
