## [48. 旋转图像](https://leetcode-cn.com/problems/rotate-image/)

## 题目

给定一个 n × n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

```java
示例 1:

给定 matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
示例 2:

给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
```


链接：https://leetcode-cn.com/problems/rotate-image

## 解题记录

+ 优先水平或垂直方向翻转矩阵
+ 然后再沿着对角线方向翻转矩阵就可以得到旋转之后的矩阵

```java
/**
 * @author: ffzs
 * @Date: 2020/12/19 上午8:35
 */
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < (n / 2); i++) {
            swap(matrix, i, n-1-i);
        }

        for (int i = 0; i < (n - 1); i++) {
            for (int j=n-1; j>i; j--) {
                deepSwap(matrix, j, i);
            }
        }
    }

    private void swap(int[][] matrix, int i1, int i2) {
        int[] tmp = matrix[i1];
        matrix[i1] = matrix[i2];
        matrix[i2] = tmp;
    }

    private void deepSwap(int[][] matrix, int x, int y){
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[y][x];
        matrix[y][x] = tmp;
    }
}
```

![image-20201219084842056](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201219084842056.png)