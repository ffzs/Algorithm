## [59. 螺旋矩阵 II](https://leetcode-cn.com/problems/spiral-matrix-ii/)

## 题目

给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

```java
示例 1：
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
    
示例 2：
输入：n = 1
输出：[[1]]
```

```java
提示：
1 <= n <= 20
```


链接：https://leetcode-cn.com/problems/spiral-matrix-ii

## 解题记录

+ 通过控制边界，逐个添加1~n*n即可

```java
/**
 * @author: ffzs
 * @Date: 2021/3/16 上午7:51
 */
public class Solution {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, left = 0, right = n-1, bottom = n-1;
        int x = 1;

        while (true) {
            for (int i = left; i <= right; i++) res[top][i] = x++;
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) res[i][right] = x++;
            if (left > --right) break;
            for (int i = right; i >= left; i--) res[bottom][i] = x++;
            if (top > --bottom) break;
            for (int i = bottom; i >= top; i--) res[i][left] = x++;
            if (++left > right) break;
        }

        return res;
    }

}
```

![image-20210316080328218](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210316080328218.png)