## [867. 转置矩阵](https://leetcode-cn.com/problems/transpose-matrix/)

## 题目

给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。

矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。

```java
示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[1,4,7],[2,5,8],[3,6,9]]
示例 2：

输入：matrix = [[1,2,3],[4,5,6]]
输出：[[1,4],[2,5],[3,6]]
```

```java
提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
-109 <= matrix[i][j] <= 109
```


链接：https://leetcode-cn.com/problems/transpose-matrix

## 解题记录

+ 由于本题的转换的矩阵长宽不等，因此需要新建数组
+ 然后长宽互换写入即可

```java
/**
 * @author: ffzs
 * @Date: 2021/2/25 上午8:26
 */
public class Solution {

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }

}
```

![image-20210225084014992](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210225084014992.png)