## [73. 矩阵置零](https://leetcode-cn.com/problems/set-matrix-zeroes/)

## 题目

给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

```java
示例 1:

输入: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2:

输入: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
```

```java
进阶:

一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？
```


链接：https://leetcode-cn.com/problems/set-matrix-zeroes

## 解题记录

+ 直接通过两个数组标记需要转话为0的行和列，先标记再转化

```java
/**
 * @author: ffzs
 * @Date: 2021/3/21 上午7:43
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            if (row[i]) Arrays.fill(matrix[i], 0);
        }

        for (int i = 0; i < n; i++) {
            if (col[i]) {
                for (int j = 0; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }
}
```

![image-20210321081112117](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210321081112117.png)

## 进阶

+ 通过矩阵自身第一行和第一列作为标记，同时记录第一行第一列最后是否需要在更改为0

```java
/**
 * @author: ffzs
 * @Date: 2021/3/21 上午8:01
 */
public class Solution2 {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean isCol = false, isRow = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) isRow = true;
                    if (j == 0) isCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }

        if (isRow) Arrays.fill(matrix[0], 0);
        if (isCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

}
```

![image-20210321081053860](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210321081053860.png)