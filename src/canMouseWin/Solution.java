package canMouseWin;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/5/10 上午8:53
 * 1. 分别 bfs 猫和老鼠 到 food 的 次数， 猫小于老鼠， 说明 猫先到 cat win return false
 * 2. bfs 老鼠时 检测 到 cat 的距离是否在猫的射程， 如果是 continue
 * 3. 老鼠的起点位置在射程内说明是循环 continue
 * 3. A*
 *
 */
public class Solution {
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int m, n, N;
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        m = grid.length;
        n = grid[0].length();
        N = m * n;

        int mouse = 0, cat = 0, food = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == 'M') mouse = i * n + j;
                else if (c == 'F') food = i * n + j;
                else if (c == 'C') cat = i * n + j;
            }
        }

        // int[mouse][cat]
        int[][] cf = new int[N][N], mf = new int[N][N];

        for (int i = 0; i < N; i++) {
            if (i == food) continue;
            mf[i][i] = -1;
            cf[i][i] = 1;
            mf[food][i] = 1;
            cf[food][i] = -1;
            mf[i][food] = -1;
            cf[i][food] = 1;
        }

        for (int round = 0; round < 1000; ++round) {
            boolean changed = false;
            for (int i = 0; i < N; i++) {
                int mx = i / n, my = i % n;
                if (grid[mx].charAt(my) == '#') continue;
                for (int j = 0; j < N; j++) {
                    int cx = j / n, cy = j % n;
                    if (grid[cx].charAt(cy) == '#') continue;

                    if (mf[i][j] == 0) {
                        boolean win = false, lose = true;
                        for (int[] dir : directions) {
                            for (int jump = 0; jump <= mouseJump; jump++) {
                                int mxx = mx + dir[0] * jump, myy = my + dir[1] * jump;
                                if (isValid(mxx, myy)) break;
                                if (grid[mxx].charAt(myy) == '#') break;
                                int k = mxx * n + myy;
                                lose &= cf[k][j] == 1;
                                if (cf[k][j] == -1) {
                                    win = true;
                                    break;
                                }
                            }
                            if (win) break;
                        }
                        mf[i][j] = win ? 1 : lose ? -1: 0;
                        if (win || lose) changed = true;
                    }

                    if (cf[i][j] == 0) {
                        boolean win = false, lose = true;
                        for (int[] dir : directions) {
                            for (int jump = 0; jump <= catJump; jump++) {
                                int cxx = cx + dir[0] * jump, cyy = cy + dir[1] * jump;
                                if (isValid(cxx, cyy)) break;
                                if (grid[cxx].charAt(cyy) == '#') break;
                                int k = cxx * n + cyy;
                                lose &= mf[i][k] == 1;
                                if (mf[i][k] == -1) {
                                    win = true;
                                    break;
                                }
                            }
                            if (win) break;
                        }
                        cf[i][j] = win ? 1 : lose ? -1:0;
                        if (win || lose) changed = true;
                    }
                }
            }
            System.out.println(Arrays.deepToString(mf));
            if (mf[mouse][cat] == 1) return true;
            if (mf[mouse][cat] == -1) return false;

            if (!changed) return false;
        }
        return false;
    }

    private boolean isValid (int x, int y) {
        return x < 0 || y < 0 || x >= m || y >= n;
    }

}
