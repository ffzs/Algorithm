## [130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)

## 题目

给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。

找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。

```java
示例:

X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：

X X X X
X X X X
X X X X
X O X X
解释:

被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
```


链接：https://leetcode-cn.com/problems/surrounded-regions

## 解题记录

+ 根据题意可知，只有边缘是O的情况才不会被替换为X
+ 我们遍历边缘，如果是O找到可以到达的O，并进行标记
+ 最终将原数组中的没有没有被标记过的O更换为X
+ 查找过程使用有记忆的深度优先搜索



```java
/**
 * @author: ffzs
 * @Date: 2020/8/11 上午7:52
 */
public class Solution {
    int[][] step;
    char[][] board;
    int m, n;
    int[][] directions = {{0,1}, {1, 0}, {-1, 0}, {0, -1}};
    public void solve(char[][] board) {
        m = board.length;
        if (m == 0) return;
        n = board[0].length;
        this.board = board;

        step = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 || i==m-1 || j==0 || j==n-1) {
                    if (board[i][j] == 'O') findO(i,j);
                    else step[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && step[i][j] != -1) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void findO(int i, int j) {
        step[i][j] = -1;
        for (int[] dir : directions) {
            int ii = dir[0] + i;
            int jj = dir[1] + j;
            if (isValid(ii, jj) && step[ii][jj]==0 && board[ii][jj] == 'O') {
                findO(ii, jj);
            }
        }
    }

    private boolean isValid (int ii, int jj) {
        return ii>=0 && ii<m && jj>=0 && jj<n;
    }
}
```

![image-20200811081439889](README.assets/image-20200811081439889.png)