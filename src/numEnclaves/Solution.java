package numEnclaves;

/**
 * @author: ffzs
 * @Date: 2022/2/12 上午8:12
 */

class UnionFind {
    private int[] parent;
    private boolean[] onEdge;
    private int[] rank;

    public UnionFind(int[][] g) {
        int m = g.length, n = g[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        onEdge = new boolean[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1) {
                    int idx = i * n + j;
                    parent[idx] = idx;
                    if (i == 0 || j == 0 || i == m - 1 || j == n - 1) onEdge[idx] = true;
                }
            }
        }
    }

    public int find(int idx) {
        if (parent[idx] != idx) parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    public void union (int x, int y) {
        int fatherX = find(x);
        int fatherY = find(y);
        if (fatherX != fatherY) {
            if (rank[fatherX] == rank[fatherY]) rank[fatherX]++;
            if (rank[fatherX] > rank[fatherY]) {
                parent[fatherY] = fatherX;
                onEdge[fatherX] |= onEdge[fatherY];
            }
            else {
                parent[fatherX] = fatherY;
                onEdge[fatherY] |= onEdge[fatherX];
            }
        }
    }

    public boolean onEdge(int idx) {
        return onEdge[find(idx)];
    }
}

public class Solution {

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int idx = i * n + j;
                    if (j + 1 < n && grid[i][j+1] == 1) uf.union(idx, idx + 1);
                    if (i + 1 < m && grid[i+1][j] == 1) uf.union(idx, idx + n);
                }
            }
        }
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1 && !uf.onEdge(i * n + j)) res ++;
            }
        }
        return res;
    }

}
