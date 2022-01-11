package isEscapePossible;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/1/11 上午7:35
 */
public class Solution {
    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};
    private static int N = 1_000_000;
    Map<Integer, Integer> mx = new HashMap<>(), my = new HashMap<>();
    int[] hx, hy;
    boolean[][] vi;
    int idx = 0;
    int xi = 1, yi = 1;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0) return true;
        int n = blocked.length + 2;
        hx = new int[3 * n];
        hy = new int[3 * n];

        addPoint(source);
        addPoint(target);

        for (int[] ints : blocked) {
            addPoint(ints);
        }

        Arrays.sort(hx);
        Arrays.sort(hy);

        for (int i = 0; i < 3 * n; i++) {
            if (i == 0) {
                mx.put(hx[i], 0);
                my.put(hy[i], 0);
                continue;
            }

            if (hx[i] != hx[i-1]) mx.put(hx[i], xi++);
            if (hy[i] != hy[i-1]) my.put(hy[i], yi++);
        }

        vi = new boolean[xi][yi];
        System.out.println(mx);
        for (int[] ints : blocked) {
            vi[mx.get(ints[0])][my.get(ints[1])] = true;
        }

        return dfs(mx.get(source[0]), my.get(source[1]), mx.get(target[0]), my.get(target[1]));
    }


    private boolean dfs (int x, int y, int tx, int ty) {
        if (x == tx && y == ty) return true;
        vi[x][y] = true;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (isValid(nx, ny) && !vi[nx][ny] && dfs(nx, ny, tx, ty)) return true;
        }
        return false;
    }

    private boolean isValid (int x, int y) {
        return x >= 0 && y >= 0 && x < xi && y < yi;
    }

    private void addPoint(int[] p) {
        hx[idx] = p[0] >= 1 ? p[0] - 1 : p[0];
        hy[idx++] = p[1] >= 1 ? p[1] - 1 : p[1];
        hx[idx] = p[0];
        hy[idx++] = p[1];
        hx[idx] = p[0] + 1 < N ? p[0] + 1 : p[0];
        hy[idx++] = p[1] + 1 < N ? p[1] + 1 : p[1];
    }

}
