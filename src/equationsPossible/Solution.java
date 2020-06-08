package equationsPossible;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/8
 */
public class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);

        for (String equation : equations) {
            char[] charArray = equation.toCharArray();
            if (charArray[1] == '=') {
                int index1 = charArray[0] - 'a';
                int index2 = charArray[3] - 'a';
                unionFind.union(index1, index2);
            }
        }

        for (String equation : equations) {
            char[] charArray = equation.toCharArray();
            if (charArray[1] == '!') {
                int index1 = charArray[0] - 'a';
                int index2 = charArray[3] - 'a';

                if (unionFind.isConnected(index1, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class UnionFind {

        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            parent[rootX] = rootY;
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
