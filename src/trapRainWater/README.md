## 407. 接雨水 II

## 题目

给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。

```java
示例 1:

输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
输出: 4

解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。

示例 2:

输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
输出: 10
```

```java
提示:

m == heightMap.length
n == heightMap[i].length
1 <= m, n <= 200
0 <= heightMap[i][j] <= 2 * 104
```


链接：https://leetcode-cn.com/problems/trapping-rain-water-ii

## 解题记录

+ 首先最外层是不会有储水能力的
+ 然后这里通过优先队列维护圈内部最小值
+ 也就是说，因为短板效应，如果一个点它的周边都是高于其自身高度，说明其有储水功能，因此提高它的高度
+ 直到所有都遍历完为止

```java
/**
 * @author: ffzs
 * @Date: 2021/11/3 上午7:23
 */
public class Solution {
    static int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2 || heightMap[0].length <= 2) return 0;

        int n = heightMap.length;
        int m = heightMap[0].length;

        boolean[][] step = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n-1 || j == m-1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    step[i][j] = true;
                }
            }
        }

        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0], y = cur[1] + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && !step[x][y]) {
                    if (cur[2] > heightMap[x][y]) res += cur[2] - heightMap[x][y];
                    pq.offer(new int[]{x, y, Math.max(heightMap[x][y], cur[2])});
                    step[x][y] = true;
                }
            }
        }
        return res;
    }

}
```

![image-20211103085907040](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211103085907040.png)