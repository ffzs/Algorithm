## 576. 出界的路径数

## 题目

给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。

给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。

```java
示例 1：
输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
输出：6
    
示例 2：
输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
输出：12
```

```java
提示：

1 <= m, n <= 50
0 <= maxMove <= 50
0 <= startRow < m
0 <= startColumn < n
```


链接：https://leetcode-cn.com/problems/out-of-boundary-paths

## 解题记录

+ 记忆化深度优先搜索
+ 通过数组`[row][[col][step]`记录访问的结果，去掉重复的情况
+ 然后通过深度优先遍历每个点的四个方向
+ 在到达最大步数说是到达边界时返回即可

```java
/**
 * @author: ffzs
 * @Date: 2021/8/15 上午7:04
 * 通过maxMove剪枝的深度优先搜索
 * return条件 到达边界或是到达 move上限
 */

public class Solution {

    int[][][] visited;
    final int MOD = 1_000_000_007;
    int m, n, N;
    int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        N = maxMove;
        visited = new int[m][n][N+1];
        for (int[][] ints : visited) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dfs(startRow, startColumn, 0);
    }

    private int dfs(int row, int col, int s){
        if (s == N) return isOut(row, col)? 1: 0;
        if (isOut(row, col)) return 1;
        if (visited[row][col][s] != -1) return visited[row][col][s];
        int sum = 0;
        for (int[] dir : dirs) {
            sum += dfs(row + dir[0], col + dir[1], s + 1);
            if (sum >= MOD) sum -= MOD;
        }
        return visited[row][col][s] = sum;
    }

    private boolean isOut(int row, int col) {
        return row >= m || row < 0 || col >= n || col < 0;
    }

}
```

![image-20210815075941219](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210815075941219.png)