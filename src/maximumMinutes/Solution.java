package maximumMinutes;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2023/11/9 上午9:18
 */
public class Solution {
    static int[][] dirs = {{-1,0}, {0, -1}, {1, 0}, {0,1}};
    int m,n;
    public int maximumMinutes(int[][] grid) {
        m=grid.length;
        n=grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});

        int[] ret = bfs(grid, q);
        int m0 = ret[0], m1 = ret[1], m2 = ret[2];

        if (m0 < 0) return -1;

        q.clear();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) q.offer(new int[]{i,j});
            }
        }

        ret = bfs(grid, q);
        int f0 = ret[0], f1 = ret[1], f2 = ret[2];

        if (f0 < 0) return (int)1e9;

        int d = f0 - m0;

        if (d < 0) return -1;

        if (m1 >= 0 && f1 - m1 > d || m2 >= 0 && f2 - m2 > d) return d;

        return d - 1;
    }

    private int[] bfs (int[][] grid, Queue<int[]> q) {
        int[][] time = new int[m][n];
        for (int[] it : time) {
            Arrays.fill(it, -1);
        }

        for (int[] it : q) {
            time[it[0]][it[1]] = 0;
        }


        int t = 1;
        int x,y;
        while (!q.isEmpty()) {
            int size = q.size();
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                x = cur[0];
                y = cur[1];

                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (isValid(nx, ny) && grid[nx][ny] == 0 && time[nx][ny] < 0) {
                        time[nx][ny] = t;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
            t+=1;
        }
        System.out.println(Arrays.deepToString(time));
        return new int[] {time[m-1][n-1], time[m-1][n-2], time[m-2][n-1]};
    }

    private boolean isValid(int x, int y){
        return x>=0 && y>=0 && x<m && y<n;
    }

}
