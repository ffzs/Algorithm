## 279. 完全平方数

## 题目

给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

```java
示例 1：

输入：n = 12
输出：3 
解释：12 = 4 + 4 + 4
示例 2：

输入：n = 13
输出：2
解释：13 = 4 + 9
```

```java
提示：

1 <= n <= 104
```


链接：https://leetcode-cn.com/problems/perfect-squares

## 解题记录

+ 动态规划，通过dp[i]表示能够达成i值使用最小情况
+ 这里有个情况就是每到一个新的值得平方位置的时候，那么要dp[i]一定为1
+ 因此没过一个j*j的时候我们就要更新之前的`dp[i<j*j]`以确保之前的值都是正确的

```java
/**
 * @author: ffzs
 * @Date: 2021/6/11 上午7:03
 */
public class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                min = Math.min(min, dp[i - j*j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
```

![image-20210611072919761](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210611072919761.png)