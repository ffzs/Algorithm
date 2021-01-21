package findCriticalAndPseudoCriticalEdges;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/1/21 下午7:43
 */

class Edge {
    int id,x,y,len;

    public Edge(int id, int x, int y, int len) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.len = len;
    }
}

class UniFind {
    private int[] f, rank;

    public UniFind(int n) {
        this.f = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            this.f[i] = i;
            this.rank[i] = 1;
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
        }
        else {
            rank[fx] += rank[fy];
            f[fy] = fx;
        }
        return true;
    }


}

public class Solution {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        List<Edge> edgeList = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            edgeList.add(new Edge(i, edges[i][0], edges[i][1], edges[i][2]));
        }

        edgeList.sort(Comparator.comparingInt(a -> a.len));

        UniFind uni = new UniFind(n);
        int minWeight = getWeight(edgeList, uni, 0);

        List<Edge> tmp = new ArrayList<>(edgeList);
        for (Edge edge : edgeList) {
            tmp.remove(edge);
            if (minWeight != getWeight(tmp, new UniFind(n), 0)) res.get(0).add(edge.id);
            tmp.add(edge);
        }

        for (Edge edge : edgeList) {
            if (res.get(0).contains(edge.id)) continue;

            UniFind u = new UniFind(n);
            u.unionSet(edge.x, edge.y);
            if (minWeight == getWeight(tmp, u, edge.len)) res.get(1).add(edge.id);
        }
        return res;
    }

    private int getWeight(List<Edge> eds, UniFind uni, int w){
        eds.sort(Comparator.comparingInt(a -> a.len));
        for (Edge edge : eds) {
            if (uni.unionSet(edge.x, edge.y)) {
                w += edge.len;
            }
        }
        return w;
    }
}
