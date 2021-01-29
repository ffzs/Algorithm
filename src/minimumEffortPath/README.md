## [1631. 最小体力消耗路径](https://leetcode-cn.com/problems/path-with-minimum-effort/)

## 题目

你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。

一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。

请你返回从左上角走到右下角的最小 体力消耗值 。

```java
示例 1：
输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
输出：2
解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。

示例 2：
输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
输出：1
解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。

示例 3：
输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
输出：0
解释：上图所示路径不需要消耗任何体力。
```




```java
提示：

rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 106
```


链接：https://leetcode-cn.com/problems/path-with-minimum-effort

## 解题记录

![image-20210129204608952](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210129204608952.png)

+ 通过并查集求解，体力消耗可以视为两个点之间的权重
+ 优先整理出边，然后通过全中排序
+ 通过逐步联通两点，然后通过判断是否开始和结尾是否已经联通
+ 如果联通返回当前边的权重

```java
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
```

![image-20210129205017912](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210129205017912.png)