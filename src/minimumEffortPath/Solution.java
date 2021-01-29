package minimumEffortPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/1/29 上午8:57
 */

class Edge {
    int x, y, weight;

    public Edge(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}

class UnionFind {
    int[] f, rank;

    public UnionFind(int n) {
        f = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) f[i] = i;
        Arrays.fill(rank, 1);
    }

    public int find(int i) {
        if (f[i] != i) f[i] = find(f[i]);
        return f[i];
    }

    public void union (int i, int j) {
        int fi = find(i), fj = find(j);
        if (fi == fj) return;
        if (rank[fi] < rank[fj]) {
            int tmp = fi;
            fi = fj;
            fj = tmp;
        }
        f[fj] = fi;
        if (rank[fi] == rank[fj]) rank[fi] ++;
    }

    public boolean connected (int i, int j) {
        return find(i) == find(j);
    }
}

public class Solution {

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m) edges.add(new Edge(i * n + j, (i+1) * n + j, Math.abs(heights[i][j] - heights[i+1][j])));
                if (j + 1 < n) edges.add(new Edge(i * n + j, i * n + j + 1, Math.abs(heights[i][j] - heights[i][j+1])));
            }
        }

        edges.sort(Comparator.comparingInt(a -> a.weight));

        UnionFind uni = new UnionFind(m*n);
        int  end = m*n -1;
        for (Edge edge : edges) {
            uni.union(edge.x, edge.y);
            if (uni.connected(0, end)) return edge.weight;
        }
        return 0;
    }
}
