package matrixRankTransform;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2023/1/25 上午11:49
 */

class UnionFind {
    int n;
    int[] parent, size;

    UnionFind (int n) {
        this.n = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find (int idx) {
        return parent[idx] == idx ? idx: (parent[idx] = find(parent[idx]));
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (size[a] > size[b]) {
                parent[b] = a;
                size[a] += size[b];
            }
            else{
                parent[a] = b;
                size[b] += size[a];
            }
        }
    }
}
public class Solution {

    public int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        UnionFind uf = new UnionFind(m *n);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0, v; i < n; i++) {
            map.clear();
            for (int j = 0; j < m; j++) {
                v = matrix[i][j];
                if (!map.containsKey(v)) map.put(v, new ArrayList<>());
                map.get(v).add(i * m + j);
            }

            for (List<Integer> value : map.values()) {
                for (int k = 1; k < value.size(); k++) {
                    uf.union(value.get(k-1), value.get(k));
                }
            }
        }

        for (int j = 0, v; j < m; j++) {
            map.clear();
            for (int i = 0; i < n; i++) {
                v = matrix[i][j];
                if (!map.containsKey(v)) map.put(v, new ArrayList<>());
                map.get(v).add(i * m + j);
            }

            for (List<Integer> value : map.values()) {
                for (int k = 1; k < value.size(); k++) {
                    uf.union(value.get(k-1), value.get(k));
                }
            }
        }

        List<Integer>[] adj = new ArrayList[m*n];

        int[] inDegree = new int[m*n];
        for (int i = 0; i < n; i++) {
            int[][] v = new int[m][2];
            for (int j = 0; j < m; j++) {
                v[j] = new int[]{matrix[i][j], j};
            }
            Arrays.sort(v, (a, b) -> a[0] - b[0]);
            for (int j = 0; j < m - 1; j++) {
                if (v[j][0]!=v[j+1][0]) {
                    int p = uf.find(i * m + v[j][1]);
                    int b = uf.find(i * m + v[j+1][1]);
                    if (adj[p] == null) adj[p] = new ArrayList<>();
                    adj[p].add(b);
                    inDegree[b]+=1;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            int[][] v = new int[n][2];
            for (int i = 0; i < n; i++) {
                v[i] = new int[]{matrix[i][j], i};
            }
            Arrays.sort(v, (a, b) -> a[0] - b[0]);
            for (int i = 0; i < n - 1; i++) {
                if (v[i][0]!=v[i+1][0]) {
                    int p = uf.find(v[i][1] * m + j);
                    int b = uf.find(v[i+1][1] * m + j);
                    if (adj[p] == null) adj[p] = new ArrayList<>();
                    adj[p].add(b);
                    inDegree[b]+=1;
                }
            }
        }

        int[] values = new int[m * n];
        Arrays.fill(values, 1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < m*n; i++) {
            if (uf.find(i) == i && inDegree[i] == 0 && adj[i] != null) q.offer(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            for (Integer v : adj[u]) {
                values[v] = Math.max(values[v], values[u] + 1);
                inDegree[v] -= 1;
                if (inDegree[v] == 0 && adj[v] != null) q.offer(v);
            }
        }

        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = values[uf.find(i*m+j)];
            }
        }
        return res;
    }

}
