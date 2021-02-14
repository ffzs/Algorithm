package minSwapsCouples;

/**
 * @author: ffzs
 * @Date: 2021/2/14 上午9:12
 */

class UnionFind {
    private int[] f;
    private int count;

    public UnionFind(int n) {
        this.count = n;
        this.f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
    }

    public int find(int i) {
        if (f[i] != i) f[i] = find(f[i]);
        return f[i];
    }

    public void union (int i, int j) {
        int fi = find(i), fj = find(j);
        if (fi == fj) return;
        f[fi] = fj;
        count--;
    }

    public int getCount () {
        return this.count;
    }
}

public class Solution {

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        UnionFind uni = new UnionFind(n/2);
        for (int i = 0; i < n; i += 2) {
            uni.union(row[i]/2, row[i+1]/2);
        }

        return n/2 - uni.getCount();
    }
}
