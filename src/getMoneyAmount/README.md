## 375. 猜数字大小 II

## 题目

我们正在玩一个猜数游戏，游戏规则如下：

我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。

每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。

然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。

```java
示例:

n = 10, 我选择了8.

第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。

游戏结束。8 就是我选的数字。

你最终要支付 5 + 7 + 9 = 21 块钱。
给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。
```


链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii

## 解题记录

+ 通过动态规划求解
+ 首先定义动态规划矩阵$dp[i][j] = x$ 表示在$i...j$ 范围内的值为x，那么$dp[i][j]$从何而来，我们可以假设在$i..j$中我们首先选择了k作为目标这里$k\isin[i,j]$ ,其值就是在k选择的范围内使得$dp[i][j]$最小的值，即 $dp[i][j] = \min_{\mathclap{i\le k\le\ j}}     \{max(dp[i][k-1], dp[k+1][j]) + k\}$
+ 最终结果也就是$dp[i][n]$

```java
/**
 * @author: ffzs
 * @Date: 2021/11/12 上午7:34
 */
public class Solution {

    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for (int i = n - 1; i > 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = (i + j) >>> 1; k < j; k++) {
                    int c = k + Math.max(dp[i][k-1], dp[k+1][j]);
                    min = Math.min(min, c);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n];
    }

}
```

![image-20211112080738199](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211112080738199.png)

```c++
class Solution {
public:
    int getMoneyAmount(int n) {
        int dp[n+1][n+1];
        for (int i = 0; i < n + 1 ; ++i) {
            for (int j = 0; j < n + 1; ++j) {
                dp[i][j] = 0;
            }
        }
        for (int i = n-1; i > 0; --i) {
            for (int j = i+1; j <=n ; ++j) {
                int minC = INT_MAX;
                for (int k = (i+j) >> 1; k < j; ++k) {
                    int c = k + max(dp[i][k-1], dp[k+1][j]);
                    minC = min(minC, c);
                }
                dp[i][j] = minC;
            }
        }
        return dp[1][n];
    }
};
```

![image-20211112082443243](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211112082443243.png)