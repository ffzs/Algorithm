package containVirus;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/7/18 上午8:15
 */
public class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int containVirus(int[][] isInfected) {
        int m = isInfected.length, n = isInfected[0].length;
        int res = 0, mark;
        List<Set<Integer>> lst = new ArrayList<>();
        List<Integer> walls = new ArrayList<>();
        while (true) {
            mark = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] != 1) continue;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    Set<Integer> neighbor = new HashSet<>();
                    int wall = 0;
                    mark -= 1;
                    isInfected[i][j] = mark;

                    while (!queue.isEmpty()) {
                        int[] arr = queue.poll();
                        int x = arr[0], y = arr[1];
                        for (int[] dir : dirs) {
                            int xx = dir[0] + x, yy = dir[1] + y;
                            if (isValid(xx, yy, m, n)) {
                                if (isInfected[xx][yy] == 1) {
                                    queue.offer(new int[]{xx, yy});
                                    isInfected[xx][yy] = mark;
                                }
                                else if (isInfected[xx][yy] == 0) {
                                    wall += 1;
                                    neighbor.add(100 * xx + yy);
                                }
                            }
                        }
                    }
                    lst.add(neighbor);
                    walls.add(wall);
                }
            }
            if (lst.isEmpty()) break;

            int idx = 0;
            for (int i = 1; i < lst.size(); i++) {
                if (lst.get(i).size() > lst.get(idx).size()) idx = i;
            }

            res += walls.get(idx);
            if (lst.size() == 1) break;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isInfected[i][j] >= 0) continue;
                    if (isInfected[i][j] != -idx-1) isInfected[i][j] = 1;
                    else isInfected[i][j] = 2;
                }
            }
            for (int i = 0; i < lst.size(); i++) {
                if (i == idx) continue;
                for (int val : lst.get(i)) {
                    int x= val / 100, y = val % 100;
                    isInfected[x][y] = 1;
                }
            }
            lst.clear();
            walls.clear();
        }
        return res;
    }

    private boolean isValid (int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}
