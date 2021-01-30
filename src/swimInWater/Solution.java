package swimInWater;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/1/30 下午7:59
 */
class Edge {
    int x,y,weight;

    public Edge(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }
}

class UnionFind {
    int[] f;

    public UnionFind(int n) {
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
    }

    public int find(int i) {
        if (i != f[i]) f[i] = find(f[i]);
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
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edges.add(new Edge(i, j, grid[i][j]));
            }
        }

        edges.sort(Comparator.comparingInt(a -> a.weight));
        UnionFind uni = new UnionFind(n*n);
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int end = n*n -1;

        for (Edge edge : edges) {
            int x=edge.x, y=edge.y;
            for (int[] dir : directions) {
                int xx = dir[0] + edge.x, yy = dir[1] + edge.y;
                if (xx>=0 && xx<n && yy>=0 && yy<n && grid[xx][yy] <= edge.weight) {
                    uni.union(x*n+y, xx*n+yy);
                }
                if (uni.connected(0, end)) return edge.weight;
            }
        }
        return -1;
    }
}
