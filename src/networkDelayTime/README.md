## 743. 网络延迟时间

## 题目

有 n 个网络节点，标记为 1 到 n。

给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。

现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 

```java
示例 1：



输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
输出：2
示例 2：

输入：times = [[1,2,1]], n = 2, k = 1
输出：1
示例 3：

输入：times = [[1,2,1]], n = 2, k = 2
输出：-1
```



```java
提示：

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
所有 (ui, vi) 对都 互不相同（即，不含重复边）
```


链接：https://leetcode-cn.com/problems/network-delay-time

## 解题记录

+ 通过广度优先搜索
+ 首先创建搜索表结构，将时间写入
+ 然后通过连接关系计算到达所有点的时间
+ 然后再返回最大时间即可
+ 如果有未到达点返回-1

```java
/**
 * @author: ffzs
 * @Date: 2021/8/2 上午6:54
 */
public class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = Integer.MAX_VALUE/2;
        int[][] g = new int[n][n];

        for (int[] ints : g) {
            Arrays.fill(ints, INF);
        }

        for (int[] t : times) {
            g[t[0]-1][t[1]-1] = t[2];
        }

        int[] dist = new int[n];
        Arrays.fill(dist, INF);

        boolean[] visited = new boolean[n];

        dist[k-1] = 0;

        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int y = 0; y < n; y++) {
                if (!visited[y] && (x == -1 || dist[y] < dist[x])) x = y;
            }
            visited[x] = true;
            for (int y = 0; y < n; y++) {
                dist[y] = Math.min(dist[y], dist[x] + g[x][y]);
            }
        }
        int res = 0;
        for (int i : dist) {
            res = Math.max(i, res);
        }
        return res == INF? -1:res;
    }

}
```

![image-20210802072943081](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210802072943081.png)