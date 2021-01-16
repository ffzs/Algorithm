package hitBricks;

/**
 * @author: ffzs
 * @Date: 2021/1/16 上午9:13
 */
class UnionFind {

    private int[] father;
    private int[] size;

    public UnionFind(int n) {
        this.father = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        if (father[i] != i) father[i] = find(father[i]);
        return father[i];
    }

    public void union(int i, int j) {
        int fi = find(i), fj = find(j);
        if (fi != fj) {
            father[fi] = fj;
            size[fj] += size[fi];
        }
    }

    public int getSize(int i) {
        return size[find(i)];
    }
}

public class Solution {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(grid[i], 0, tmp[i], 0, n);
        }

        for (int[] hit : hits) tmp[hit[0]][hit[1]] = 0;

        int len = n * m;
        UnionFind unionFind = new UnionFind(len + 1);

        for (int i = 0; i < n; i++) {
            if (tmp[0][i] == 1) unionFind.union(i, len);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] == 1) {
                    if (tmp[i - 1][j] == 1) unionFind.union((i - 1) * n + j, i * n + j);
                    if (j > 0 && tmp[i][j - 1] == 1) unionFind.union(i * n + j - 1, i * n + j);
                }
            }
        }

        int[] res = new int[hits.length];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];

            if (grid[x][y] == 0) continue;

            int pre = unionFind.getSize(len);

            if (x == 0) unionFind.union(y, len);

            for (int[] dir : directions) {
                int xx = x + dir[0], yy = y + dir[1];
                if (xx >= 0 && xx < m && yy >= 0 && yy < n && tmp[xx][yy] == 1){
                    unionFind.union(x*n + y, xx*n + yy);
                }
            }

            int cur = unionFind.getSize(len);
            res[i] = Math.max(0, cur - pre - 1);
            tmp[x][y] = 1;
        }

        return res;
    }
}
