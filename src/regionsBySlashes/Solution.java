package regionsBySlashes;


/**
 * @author: ffzs
 * @Date: 2021/1/25 上午8:09
 */

class UnionFind {
    private int[] f;
    private int count;

    public UnionFind(int n) {
        count = n;
        f = new int[n];
        for (int i = 0; i < n; i++) f[i] = i;
    }

    public int find(int i) {
        if (f[i] != i) f[i] = find(f[i]);
        return f[i];
    }

    public void union (int i, int j) {
        int fi = find(i), fj = find(j);
        if (fi != fj) {
            f[find(i)] = find(j);
            count--;
        }
    }

    public int getCount(){
        return count;
    }
}

public class Solution {

    public int regionsBySlashes(String[] grid) {
        int m = grid.length;
        int n = 4*m*m;

        UnionFind uni = new UnionFind(n);

        for (int i = 0; i < m; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < m; j++) {
                int cell = 4 * (i * m + j);
                char c = row[j];
                if (c == '/') {
                    uni.union(cell, cell + 3);
                    uni.union(cell+1, cell + 2);
                }
                else if (c == '\\') {
                    uni.union(cell, cell + 1);
                    uni.union(cell + 2, cell + 3);
                }
                else {
                    uni.union(cell, cell + 1);
                    uni.union(cell + 2, cell + 3);
                    uni.union(cell, cell + 2);
                }

                if (j < m - 1) uni.union(cell + 1, cell + 7);
                if (i < m - 1) uni.union(cell + 2, cell + m * 4);
            }
        }

        return uni.getCount();
    }
}
