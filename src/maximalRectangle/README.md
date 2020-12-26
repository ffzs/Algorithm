## [85. 最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/)

## 题目

给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 

```java
示例 1：
输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
输出：6
解释：最大矩形如上图所示。
    
示例 2：
输入：matrix = []
输出：0
    
示例 3：
输入：matrix = [["0"]]
输出：0
    
示例 4：
输入：matrix = [["1"]]
输出：1
    
示例 5：
输入：matrix = [["0","0"]]
输出：0
```



```java
提示：

rows == matrix.length
cols == matrix[0].length
0 <= row, cols <= 200
matrix[i][j] 为 '0' 或 '1'
```


链接：https://leetcode-cn.com/problems/maximal-rectangle

## 解题记录

+ 优先通过横向标注信息，标注该点前有多少个1,也就是高度
+ 然后纵向遍历，计算面积情况，获取最大值

```java
/**
 * @author: ffzs
 * @Date: 2020/12/26 上午10:38
 */

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1'){
                    if (j == 0) tmp[i][j] = 1;
                    else tmp[i][j] = tmp[i][j-1] + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) continue;
                int width = tmp[i][j];
                res = Math.max(res, width);
                for (int k = i-1; k >= 0; k--) {
                    width = Math.min(width, tmp[k][j]);
                    res = Math.max(res, (i-k+1)*width);
                }
            }
        }
        return res;
    }
}
```

![image-20201226112041055](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201226112041055.png)

+ 可以一边遍历一边统计高度
+ 每一层计算最大面积

```java
/**
 * @author: ffzs
 * @Date: 2020/12/26 上午10:38
 */

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1'){
                    if (j == 0) tmp[i][j] = 1;
                    else tmp[i][j] = tmp[i][j-1] + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) continue;
                int width = tmp[i][j];
                res = Math.max(res, width);
                for (int k = i-1; k >= 0; k--) {
                    width = Math.min(width, tmp[k][j]);
                    res = Math.max(res, (i-k+1)*width);
                }
            }
        }
        return res;
    }
}
```

![image-20201226115342403](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201226115342403.png)