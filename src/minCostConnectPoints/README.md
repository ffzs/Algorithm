## [1584. 连接所有点的最小费用](https://leetcode-cn.com/problems/min-cost-to-connect-all-points/)

## 题目

给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。

连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。

请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。

 

```java
示例 1：
输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
输出：20
解释：
我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
注意到任意两个点之间只有唯一一条路径互相到达。

示例 2：
输入：points = [[3,12],[-2,5],[-4,1]]
输出：18

示例 3：
输入：points = [[0,0],[1,1],[1,0],[-1,1]]
输出：4

示例 4：
输入：points = [[-1000000,-1000000],[1000000,1000000]]
输出：4000000

示例 5：
输入：points = [[0,0]]
输出：0
```



```java
提示：

1 <= points.length <= 1000
-106 <= xi, yi <= 106
所有点 (xi, yi) 两两不同。
```


链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points

## 解题记录

+ 通过并查集记录联通情况
+ 对边的长短进行排序
+ 有短到长进行判断
+ 未联通的边进行计数求和



```java
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
```



![image-20210119215000382](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210119215000382.png)