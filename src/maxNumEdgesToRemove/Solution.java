package maxNumEdgesToRemove;

/**
 * @author: ffzs
 * @Date: 2021/1/27 下午8:42
 */

class UnionFind {
    int[] f;
    int count;

    public UnionFind(int n) {
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        count = n - 1;
    }

    public int find(int i) {
        if (i != f[i]) f[i] = find(f[i]);
        return f[i];
    }

    public boolean union (int i, int j) {
        int fi = find(i), fj = find(j);
        if (fi == fj) return false;

        f[fi] = fj;
        count--;
        return true;
    }

    public int getCount() {
        return count;
    }
}


public class Solution {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n+1);
        UnionFind bob = new UnionFind(n+1);

        int res = 0;

        for (int[] edge : edges) {
            if(edge[0] == 3) {
                if (!alice.union(edge[1], edge[2])) res++;
                else bob.union(edge[1], edge[2]);
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1 && (!alice.union(edge[1], edge[2]))) res++;
            else if (edge[0] == 2 && (!bob.union(edge[1], edge[2]))) res++;
        }

        if (alice.getCount() != 1 || bob.getCount() != 1) return -1;

        return res;
    }
}
