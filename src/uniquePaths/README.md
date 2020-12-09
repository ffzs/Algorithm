## [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)

## 题目

一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

问总共有多少条不同的路径？

例如，上图是一个7 x 3 的网格。有多少可能的路径？

 

```java
示例 1:

输入: m = 3, n = 2
输出: 3
解释:
从左上角开始，总共有 3 条路径可以到达右下角。

1. 向右 -> 向右 -> 向下
2. 向右 -> 向下 -> 向右
3. 向下 -> 向右 -> 向右
   示例 2:

输入: m = 7, n = 3
输出: 28
```


提示：

1 <= m, n <= 100
题目数据保证答案小于等于 2 * 10 ^ 9


链接：https://leetcode-cn.com/problems/unique-paths

## 解题记录

+ 从start到finish向下移动n-1 次
+ 向右移动m-1次
+ 一共移动m+n-2次，那么这个问题就是取出不同的向下移动方案
+ 就是m+n-2中选出m-1的情况

```java
/**
 * @author: ffzs
 * @Date: 2020/12/9 上午8:43
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        long res = 1;
        for (int i = 1, j = n; i < m; i++, j++) {
            res = res * j / i;
        }
        return (int) res;
    }
}
```

![image-20201209085519834](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201209085519834.png)

+ 动态规划

```java
/**
 * @author: ffzs
 * @Date: 2020/12/9 上午8:53
 */
public class Solution2 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
```

![image-20201209085648843](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201209085648843.png)