## 847. 访问所有节点的最短路径

## 题目

 存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。

给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。

返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。

 

```java
示例 1：


输入：graph = [[1,2,3],[0],[0],[0]]
输出：4
解释：一种可能的路径为 [1,0,2,0,3]
示例 2：



输入：graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
输出：4
解释：一种可能的路径为 [0,1,4,2,3]
```



```java
提示：

n == graph.length
1 <= n <= 12
0 <= graph[i].length < n
graph[i] 不包含 i
如果 graph[a] 包含 b ，那么 graph[b] 也包含 a
输入的图总是连通图
```


链接：https://leetcode-cn.com/problems/shortest-path-visiting-all-nodes

## 解题记录

+ 可以通过广度优先算法计算
+ 通过队列存储一个三元组：目前节点，目前访问情况，经过路径情况
+ 优先将所有节点加进队列，通过一个矩阵记录访问过的情况
+ 搜索，每一轮所有路径都只向下查找一次，因此最早达成全部访问的情况为最短
+ 因为本题n小于等于12,，因此可以使用状态压缩，通过一个数字的二进制存储访问状态

```java
/**
 * @author: ffzs
 * @Date: 2021/8/6 上午6:54
 */
public class Solution {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();

        boolean[][] visited = new boolean[n][1<<n];

        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1<<i, 0});
            visited[i][1<<i] = true;
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[1] == (1<<n) - 1) {
                res = cur[2];
                break;
            }
            for (int i : graph[cur[0]]) {
                int mask = cur[1]|1<<i;
                if (!visited[i][mask]) {
                    queue.offer(new int[]{i, mask, cur[2] + 1});
                    visited[i][mask] = true;
                }
            }
        }
        return res;
    }

}
```

![image-20210806072015857](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210806072015857.png)