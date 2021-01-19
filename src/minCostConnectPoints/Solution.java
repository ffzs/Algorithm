package minCostConnectPoints;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/1/19 下午8:23
 */

class Edge {
    int x, y, len;

    public Edge(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }
}

class UniFind {
    private int[] f, rank;

    public UniFind(int n) {
        this.rank = new int[n];
        this.f = new int[n];
        for (int i = 0; i < n; i++) {
            this.rank[i] = 1;
            this.f[i] = i;
        }
    }

    public int find(int x) {
        if (f[x] != x) f[x] = find(f[x]);
        return f[x];
    }

    public boolean unionSet(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx == fy) return false;

        if (rank[fx] < rank[fy]) {
            rank[fy] += rank[fx];
            f[fx] = fy;
        } else {
            rank[fx] += rank[fy];
            f[fy] = fx;
        }
        return true;
    }
}

public class Solution {

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UniFind uni = new UniFind(n);
        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Edge(i, j, len));
            }
        }

        edges.sort(Comparator.comparingInt(a -> a.len));

        int res = 0;
        int counter = 1;
        for (Edge e : edges) {
            if (uni.unionSet(e.x, e.y)) {
                res += e.len;
                counter++;
                if (counter == n) return res;
            }
        }
        return res;
    }
}
