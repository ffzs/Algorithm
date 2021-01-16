## [803. 打砖块](https://leetcode-cn.com/problems/bricks-falling-when-hit/)

## 题目

有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是：

一块砖直接连接到网格的顶部，或者
至少有一块相邻（4 个方向之一）砖块 稳定 不会掉落时
给你一个数组 hits ，这是需要依次消除砖块的位置。每当消除 hits[i] = (rowi, coli) 位置上的砖块时，对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。

返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。

注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。

```java
示例 1：
输入：grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
输出：[2]
解释：
网格开始为：
[[1,0,0,0]，
 [1,1,1,0]]
消除 (1,0) 处加粗的砖块，得到网格：
[[1,0,0,0]
 [0,1,1,0]]
两个加粗的砖不再稳定，因为它们不再与顶部相连，也不再与另一个稳定的砖相邻，因此它们将掉落。得到网格：
[[1,0,0,0],
 [0,0,0,0]]
因此，结果为 [2] 。
    
示例 2：
输入：grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]
输出：[0,0]
解释：
网格开始为：
[[1,0,0,0],
 [1,1,0,0]]
消除 (1,1) 处加粗的砖块，得到网格：
[[1,0,0,0],
 [1,0,0,0]]
剩下的砖都很稳定，所以不会掉落。网格保持不变：
[[1,0,0,0], 
 [1,0,0,0]]
接下来消除 (1,0) 处加粗的砖块，得到网格：
[[1,0,0,0],
 [0,0,0,0]]
剩下的砖块仍然是稳定的，所以不会有砖块掉落。
因此，结果为 [0,0] 。
```



```java
提示：

m == grid.length
n == grid[i].length
1 <= m, n <= 200
grid[i][j] 为 0 或 1
1 <= hits.length <= 4 * 104
hits[i].length == 2
0 <= xi <= m - 1
0 <= yi <= n - 1
所有 (xi, yi) 互不相同
```


链接：https://leetcode-cn.com/problems/bricks-falling-when-hit

## 解题记录

+ 通过并查集来确定联通情况
+ 优先将砖块全部敲掉，获取剩余砖块的联通情况
+ 然后通过将砖块填上，联通以后查看联通之前和联通之后，砖块的总数差来确定敲掉以后一共掉落了多少个砖块
+ 这个过程需要优先填上后敲掉的那些砖块



```java
/**
 * @author: ffzs
 * @Date: 2021/1/16 上午9:13
 */
class UnionFind {

    private int[] father;
    private int[] size;

    public UnionFind(int n) {
        this.father = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        if (father[i] != i) father[i] = find(father[i]);
        return father[i];
    }

    public void union(int i, int j) {
        int fi = find(i), fj = find(j);
        if (fi != fj) {
            father[fi] = fj;
            size[fj] += size[fi];
        }
    }

    public int getSize(int i) {
        return size[find(i)];
    }
}

public class Solution {

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] tmp = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(grid[i], 0, tmp[i], 0, n);
        }

        for (int[] hit : hits) tmp[hit[0]][hit[1]] = 0;

        int len = n * m;
        UnionFind unionFind = new UnionFind(len + 1);

        for (int i = 0; i < n; i++) {
            if (tmp[0][i] == 1) unionFind.union(i, len);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j] == 1) {
                    if (tmp[i - 1][j] == 1) unionFind.union((i - 1) * n + j, i * n + j);
                    if (j > 0 && tmp[i][j - 1] == 1) unionFind.union(i * n + j - 1, i * n + j);
                }
            }
        }

        int[] res = new int[hits.length];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];

            if (grid[x][y] == 0) continue;

            int pre = unionFind.getSize(len);

            if (x == 0) unionFind.union(y, len);

            for (int[] dir : directions) {
                int xx = x + dir[0], yy = y + dir[1];
                if (xx >= 0 && xx < m && yy >= 0 && yy < n && tmp[xx][yy] == 1){
                    unionFind.union(x*n + y, xx*n + yy);
                }
            }

            int cur = unionFind.getSize(len);
            res[i] = Math.max(0, cur - pre - 1);
            tmp[x][y] = 1;
        }

        return res;
    }
}
```

![image-20210116193604620](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210116193604620.png)