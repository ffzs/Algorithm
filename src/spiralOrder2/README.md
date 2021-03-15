## [54. 螺旋矩阵](https://leetcode-cn.com/problems/spiral-matrix/)

## 题目

给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

 

```java
示例 1：


输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
```



```java
提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
```


链接：https://leetcode-cn.com/problems/spiral-matrix

## 解题记录

+ 通过循环上右下左是个方向的边，获取数值
+ 并逐渐缩小范围直到越界

```java
/**
 * @author: ffzs
 * @Date: 2021/3/15 上午9:22
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) return new ArrayList<>();
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m*n);

        int left = 0, top = 0, right = n - 1, bottom = m - 1;

        while (true) {
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            if (left > --right) break;
            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            if (top > --bottom) break;
            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            if (++left > right) break;
        }

        return res;
    }

}
```

![image-20210315093355589](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210315093355589.png)