## [778. 水位上升的泳池中游泳](https://leetcode-cn.com/problems/swim-in-rising-water/)

## 题目

在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。
现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。
你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？



```java
示例 1:

输入: [[0,2],[1,3]]
输出: 3
解释:
时间为0时，你位于坐标方格的位置为 (0, 0)。
此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。

等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
示例2:

输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
输出: 16
解释:
 0  1  2  3  4
24 23 22 21  5
12 13 14 15 16
11 17 18 19 20
10  9  8  7  6

最终的路线用加粗进行了标记。
我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
```



```java
提示:

2 <= N <= 50.
grid[i][j] 是 [0, ..., N*N - 1] 的排列。
```


链接：https://leetcode-cn.com/problems/swim-in-rising-water

## 解题记录

+ 通过并查集判断开始和结尾是否联通
+ 从权值底的开始遍历，每到一处将周围低于该权值的点连接到一起
+ 最后判断是否联通

```java
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
```

![image-20210130205755586](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210130205755586.png)