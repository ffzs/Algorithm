## 815. 公交路线

## 题目

给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。

例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。

求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。

```java
示例 1：

输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
输出：2
解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。 
示例 2：

输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
输出：-1
```

```java
提示：

1 <= routes.length <= 500.
1 <= routes[i].length <= 105
routes[i] 中的所有值 互不相同
sum(routes[i].length) <= 105
0 <= routes[i][j] < 106
0 <= source, target < 106
```


链接：https://leetcode-cn.com/problems/bus-routes

## 解题记录

+ 优先构建连接关系
+ 通过双向BFS处理，获取最短乘车路径

```java
/**
 * @author: ffzs
 * @Date: 2021/6/28 上午6:59
 */
public class Solution {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (target == source) return 0;

        int n = routes.length;

        boolean[][] edges = new boolean[n][n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int l : routes[i]) {
                List<Integer> lst = map.getOrDefault(l, new ArrayList<>());
                for (int j : lst) {
                    edges[i][j] = edges[j][i] = true;
                }
                lst.add(i);
                map.put(l, lst);
            }
        }

        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        Queue<Integer> queue = new LinkedList<>();

        int res = Integer.MAX_VALUE;

        for (int l : map.getOrDefault(source, new ArrayList<>())) {
            visited[l] = 1;
            queue.offer(l);
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 0; j < n; j++) {
                if (edges[i][j] && visited[j] == -1) {
                    visited[j] = visited[i] + 1;
                    queue.offer(j);
                }
            }
        }

        for (int l : map.getOrDefault(target, new ArrayList<>()))
            if (visited[l] != -1 && visited[l] < res) res = visited[l];

        return res == Integer.MAX_VALUE ? -1 : res;
    }

}
```

![image-20210628072233233](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210628072233233.png)