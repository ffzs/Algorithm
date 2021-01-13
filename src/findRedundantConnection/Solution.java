package findRedundantConnection;

/**
 * @author: ffzs
 * @Date: 2021/1/13 下午7:37
 */

public class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] father = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            father[i] = i;
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (find(father, a) != find(father, b)) merge(father, a, b);
            else return edge;
        }
        return new int[0];
    }

    private int find (int[] f, int i) {
        if (f[i] != i) f[i] = find(f, f[i]);
        return f[i];
    }

    private void merge (int[] f, int i, int j) {
        f[find(f, i)] = find(f, j);
    }

}
