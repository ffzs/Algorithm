package numSimilarGroups;

/**
 * @author: ffzs
 * @Date: 2021/1/31 上午8:37
 */


class UnionFind {
    int[] f;

    public UnionFind(int n) {
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
    }

    public int find(int i) {
        if (f[i] != i) f[i] = find(f[i]);
        return f[i];
    }

    public void union(int i, int j) {
        f[find(i)] = find(j);
    }

    public boolean connected(int i, int j) {
        return find(i) == find(j);
    }
}
public class Solution {

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;

        UnionFind uni = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (uni.connected(i, j)) continue;
                if (isSame(strs[i], strs[j])) uni.union(i, j);
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (uni.find(i) == i) res++;
        }
        return res;
    }

    private boolean isSame(String s1, String s2) {
        int count = 0;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) count++;
            if (count > 2) return false;
        }
        return true;
    }

}
