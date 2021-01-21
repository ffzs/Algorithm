## [1489. 找到最小生成树里的关键边和伪关键边](https://leetcode-cn.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/)

## 题目

给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，其中 `edges[i] = [fromi, toi, weighti]` 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST) 是给定图中边的一个子集，它连接了所有节点且没有环，而且这些边的权值和最小。

请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。

请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。

```java
示例 1：

输入：n = 5, edges = [[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]
输出：[[0,1],[2,3,4,5]]
解释：上图描述了给定图。
下图是所有的最小生成树。

注意到第 0 条边和第 1 条边出现在了所有最小生成树中，所以它们是关键边，我们将这两个下标作为输出的第一个列表。
边 2，3，4 和 5 是所有 MST 的剩余边，所以它们是伪关键边。我们将它们作为输出的第二个列表。
示例 2 ：

输入：n = 4, edges = [[0,1,1],[1,2,1],[2,3,1],[0,3,1]]
输出：[[],[0,1,2,3]]
解释：可以观察到 4 条边都有相同的权值，任选它们中的 3 条可以形成一棵 MST 。所以 4 条边都是伪关键边。
```



```java
提示：

2 <= n <= 100
1 <= edges.length <= min(200, n * (n - 1) / 2)
edges[i].length == 3
0 <= fromi < toi < n
1 <= weighti <= 1000
所有 (fromi, toi) 数对都是互不相同的。
```


链接：https://leetcode-cn.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree

## 解题记录

+ 通过并查集获取最小生成树的权值和
+ 然后通过删掉每一个边之后，再分别求权值和，如果变大了，那么说明是关键边
+ 通过优先选中一条边，如果权值之和没有变化的话说说明是伪关键边

```java
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
```

![image-20210121213017708](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210121213017708.png)