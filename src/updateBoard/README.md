## [529. 扫雷游戏](https://leetcode-cn.com/problems/minesweeper/)

## 题目

让我们一起来玩扫雷游戏！

给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。

现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：

如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
如果在此次点击中，若无更多方块可被揭露，则返回面板。

```java
输入: 

[['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'M', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E'],
 ['E', 'E', 'E', 'E', 'E']]

Click : [3,0]

输出: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]
```



```java
示例 2：

输入: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'M', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]

Click : [1,2]

输出: 

[['B', '1', 'E', '1', 'B'],
 ['B', '1', 'X', '1', 'B'],
 ['B', '1', '1', '1', 'B'],
 ['B', 'B', 'B', 'B', 'B']]


```

 

```java
注意：

输入矩阵的宽和高的范围为 [1,50]。
点击的位置只能是未被挖出的方块 ('M' 或者 'E')，这也意味着面板至少包含一个可点击的方块。
输入面板不会是游戏结束的状态（即有地雷已被挖出）。
简单起见，未提及的规则在这个问题中可被忽略。例如，当游戏结束时你不需要挖出所有地雷，考虑所有你可能赢得游戏或标记方块的情况。
```


链接：https://leetcode-cn.com/problems/minesweeper

## 解题记录

+ 首先构建一个炸弹数值表，根据炸弹，获取全局所有炸弹数值情况，这样就减少了每次访问一个点都要判断周围有没有炸弹
+ 通过深度搜索判断获取信息



```java
/**
 * @author: ffzs
 * @Date: 2020/8/20 上午8:57
 */

public class Solution {
    int[][] tmp;
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
    int n, m;
    char[][] board;
    public char[][] updateBoard(char[][] board, int[] click) {
        this.n = board.length;
        this.m = board[0].length;
        tmp = new int[n][m];
        this.board = board;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'M') {
                    tmp[i][j]++;
                    for (int[] dir : directions) {
                        int ii = dir[0] + i;
                        int jj = dir[1] + j;
                        if (isValid(ii, jj)) tmp[ii][jj]++;
                    }
                }
            }
        }
        dfs(click[0], click[1]);
        return board;
    }

    private void dfs (int i, int j) {
        if (tmp[i][j] > 0) {
            if (board[i][j] != 'M') board[i][j] = (char)(tmp[i][j] + '0');
            else board[i][j] = 'X';
        }
        else if (tmp[i][j] == 0) {
            tmp[i][j] = -1;
            if (board[i][j] == 'E') {
                board[i][j] = 'B';
                for (int[] dir : directions) {
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (isValid(ii, jj) && board[ii][jj] == 'E') dfs(ii, jj);
                }
            }
        }
    }

    private boolean isValid (int ii, int jj) {
        return ii>=0 && ii < n && jj>=0 && jj < m;
    }
}
```

![image-20200820101846650](README.assets/image-20200820101846650.png)

+ 没想到结果不理想，可能是好多测试数据都是满屏炸弹的情况，那就写个正常的吧

```java
/**
 * @author: ffzs
 * @Date: 2020/8/20 上午10:19
 */
public class Solution2 {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
    int n, m;
    char[][] board;
    public char[][] updateBoard(char[][] board, int[] click) {
        this.n = board.length;
        this.m = board[0].length;
        this.board = board;

        dfs(click[0], click[1]);
        return board;
    }

    private void dfs (int i, int j) {
        if (board[i][j] == 'M') board[i][j] = 'X';
        if (board[i][j] == 'E') {
            int count = 0;
            for (int[] dir : directions) {
                int ii = dir[0] + i;
                int jj = dir[1] + j;
                if (isValid(ii, jj) && board[ii][jj] == 'M') {
                    count++;
                }
            }
            if (count != 0) {
                board[i][j] = (char)(count + '0');
            }
            else{
                board[i][j] = 'B';
                for (int[] dir : directions)
                    if (isValid(i+dir[0], j+dir[1])) dfs(i+dir[0], j+dir[1]);
            }
        }
    }

    private boolean isValid (int ii, int jj) {
        return ii>=0 && ii < n && jj>=0 && jj < m;
    }
}
```

![image-20200820102809592](README.assets/image-20200820102809592.png)