## 363. 矩形区域不超过 K 的最大数值和

## 题目

给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。

题目数据保证总会存在一个数值和不超过 k 的矩形区域。

```java
示例 1：


输入：matrix = [[1,0,1],[0,-2,3]], k = 2
输出：2
解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
示例 2：

输入：matrix = [[2,2,-1]], k = 3
输出：3
```



```java
提示：

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100
-105 <= k <= 105
```


进阶：如果行数远大于列数，该如何设计解决方案？


链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k

## 解题记录

+ 通过类似与获取前缀和的方式优先获取矩阵特定位置相加的和
+ 然后通过遍历，处理相减获得相应区域的值的方法获取所有情况，有等于k的情况直接返回即可

```java
/**
 * @author: ffzs
 * @Date: 2021/4/22 上午9:54
 */
public class Solution {

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int[][] tmp = new int[m + 1][n + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int num = matrix[i - 1][j - 1];
                if (num == k) return k;
                else if (num < k && num > res) res = num;
                num += tmp[i - 1][j] + tmp[i][j - 1] - tmp[i - 1][j - 1];
                tmp[i][j] = num;
                if (num == k) return k;
                else if (num < k && num > res) res = num;
                for (int x = 1; x <= i; x++) {
                    for (int y = 1; y <= j; y++) {
                        if ((x == i && y == j) || (x == 1 && y == 1)) continue;
                        int cur = num - tmp[i][y - 1] - tmp[x - 1][j] + tmp[x - 1][y - 1];
                        if (cur == k) return k;
                        else if (cur < k && cur > res) res = cur;
                    }
                }
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] matrix = new int[1][3];
        matrix[0] = new int[]{2, 2, -1};
        Solution solution = new Solution();
        System.out.println(solution.maxSumSubmatrix(matrix, 0));
    }
}
```

![image-20210422112424943](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210422112424943.png)

+ 方法基本相同，通过压缩矩形范围，并且通过前缀和计算范围取值情况

```java
/**
 * @author: ffzs
 * @Date: 2021/4/22 上午11:24
 */
public class Solution2 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int res = Integer.MIN_VALUE;

        for (int x = 0; x < n; x++) {
            int[] sum = new int[m];
            for (int i = x; i < n; i++) {
                for (int y = 0; y < m; y++) {
                    sum[y] += matrix[y][i];
                }
                int max = Integer.MIN_VALUE, cur = 0;
                for (int s : sum) {
                    cur = Math.max(cur+s, s);
                    max = Math.max(max, cur);
                    if (max == k) return max;
                }

                if (max < k) res = Math.max(res, max);
                else {
                    for (int y = 0; y < m; y++) {
                        int rowSum = 0;
                        for (int j = y; j < m; j++) {
                            rowSum += sum[j];
                            if (rowSum == k) return k;
                            else if (rowSum < k && rowSum > res) res = rowSum;
                        }
                    }
                }
            }
        }
        return res;
    }
}
```

![image-20210422120319218](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210422120319218.png)