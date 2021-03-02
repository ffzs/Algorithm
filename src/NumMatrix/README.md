## [304. 二维区域和检索 - 矩阵不可变](https://leetcode-cn.com/problems/range-sum-query-2d-immutable/)

## 题目

给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2)。


上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。

```java
示例:

给定 matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
```

```java
说明:

你可以假设矩阵不可变。
会多次调用 sumRegion 方法。
你可以假设 row1 ≤ row2 且 col1 ≤ col2。
```

链接：https://leetcode-cn.com/problems/range-sum-query-2d-immutable


## 解题记录

+ 通过单行的前缀和进行统计，然后获取数据的时候逐行获取范围的和，最后返回

```java
/**
 * @author: ffzs
 * @Date: 2021/3/2 上午8:31
 */
public class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        this.sum = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) this.sum[i][j] = matrix[i][j];
                else this.sum[i][j] = this.sum[i][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = 0;
        if (col1 == 0) {
            for (int i = row1; i <= row2; i++) {
                ret += this.sum[i][col2];
            }
        }
        else {
            for (int i = row1; i <= row2; i++) {
                ret += this.sum[i][col2] - this.sum[i][col1 - 1];
            }
        }
        return ret;
    }
}
```

![image-20210302090930204](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210302090930204.png)

+ 通过构建2维前缀和，记录一个从0,0到目标点x,y的矩形的和，然后求范围的时候只要通过已有范围进行裁剪即可

```java
/**
 * @author: ffzs
 * @Date: 2021/3/2 上午8:59
 */
public class NumMatrix2 {
    int[][] sum;
    public NumMatrix2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        this.sum = new int[m+1][n+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] - sum[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row2 + 1][col1] - sum[row1][col2 + 1] + sum[row1][col1];
    }
}
```

![image-20210302090903944](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210302090903944.png)