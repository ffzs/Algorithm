## 787. K 站中转内最便宜的航班

## 题目

有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 toi 抵达 pricei。

现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。

 

```java
示例 1：

输入: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
输出: 200
解释: 
城市航班图如下


从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。
示例 2：

输入: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
输出: 500
解释: 
城市航班图如下


从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。
```




```java
提示：

1 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
航班没有重复，且不存在自环
0 <= src, dst, k < n
src != dst
```


链接：https://leetcode-cn.com/problems/cheapest-flights-within-k-stops

## 解题记录

+ 动态规划

```java
/**
 * @author: ffzs
 * @Date: 2021/8/24 上午6:52
 */
public class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = (int)(1e4) * 101 + 1;
        int[][] dp = new int[k + 2][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, INF);
        }
        dp[0][src] = 0;
        for (int t = 1; t <= k + 1; t++) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                dp[t][i] = Math.min(dp[t][i], dp[t-1][j] + cost);
            }
        }
        int res = INF;
        for (int t = 1; t <= k + 1; t++) {
            res = Math.min(res, dp[t][dst]);
        }
        return res == INF? -1:res;
    }

}
```

+ 广度优先搜索
+ 重新通过数组构造邻接表，然后查找

```java
/**
 * @author: ffzs
 * @Date: 2021/8/24 上午7:06
 */
public class Solution2 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = (int)(1e4) * 101 + 1;
        int[][] g = new int[n][n];
        for (int[] flight : flights) {
            g[flight[0]][flight[1]] = flight[2];
        }
        int[] res = new int[n];
        Arrays.fill(res, INF);

        Queue<int[]> qu = new LinkedList<>();
        qu.offer(new int[]{src, 0});
        for (int i = 0; i < k + 1; i++) {
            for (int size = qu.size(); size > 0; size--) {
                int[] cur = qu.poll();
                int t = cur[0], cost = cur[1];
                for (int j = 0; j < n; j++) {
                    if (g[t][j] != 0 && g[t][j] + cost < res[j]) {
                        res[j] = g[t][j] + cost;
                        qu.offer(new int[]{j, res[j]});
                    }
                }
            }
        }
        return res[dst] == INF? -1:res[dst];
    }

}
```

![image-20210824071333661](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210824071333661.png)