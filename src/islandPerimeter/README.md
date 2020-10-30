## [463. 岛屿的周长](https://leetcode-cn.com/problems/island-perimeter/)

## 题目

给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。

网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。

岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

 

```java
示例 :

输入:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

输出: 16
```

解释: 它的周长是下面图片中的 16 个黄色的边：

![image-20201030093650602](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201030093650602.png)



链接：https://leetcode-cn.com/problems/island-perimeter


## 解题记录

+ 暴力解法
+ 通过查找1周围0或边的个数即可。

```java
/**
 * @author: ffzs
 * @Date: 2020/10/30 上午9:32
 */

public class Solution {

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] dir : directions) {
                    if (grid[i][j] == 0) continue;
                    int ii = i + dir[0];
                    int jj = j + dir[1];
                    if (ii < 0 || ii >= n || jj < 0 || jj >= m || grid[ii][jj] == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
```

![image-20201030100158207](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201030100158207.png)

+ 每个1周围有4个边，两个1相连就会少2个，相连的方式有两种，一种是上下相连，另一种是左右
+ 统计1的个数即可

```java
/**
 * @author: ffzs
 * @Date: 2020/10/30 上午10:08
 */
public class Solution2 {

    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int c = 0, lr = 0, ud = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    c++;
                    if (j+1<m && grid[i][j+1] == 1) lr++;
                    if (i+1<n && grid[i+1][j] == 1) ud++;
                }
            }
        }
        return c*4 - (lr+ud) * 2;
    }
}
```

![image-20201030103517285](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201030103517285.png)