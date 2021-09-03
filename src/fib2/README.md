## 剑指 Offer 10- I. 斐波那契数列

## 题目

写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

 

```java
示例 1：

输入：n = 2
输出：1
示例 2：

输入：n = 5
输出：5
```



```java
提示：

0 <= n <= 100
```


链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof

## 解题记录

+ 动态规划求解，状态转移方程已经给了
+ 注意mod就行

```java
/**
 * @author: ffzs
 * @Date: 2021/9/4 上午6:49
 */
public class Solution {

    public int fib(int n) {
        if (n <= 1) return n;
        final int MOD = (int)(1e9)+7;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]);
            if (dp[i] > MOD) {
                dp[i] -= MOD;
            }
        }
        return dp[n];
    }
}
```

![image-20210904070520191](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210904070520191.png)