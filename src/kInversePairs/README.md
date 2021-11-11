## 629. K个逆序对数组

## 题目

给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。

逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。

由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。

```java
示例 1:

输入: n = 3, k = 0
输出: 1
解释: 
只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
示例 2:

输入: n = 3, k = 1
输出: 2
解释: 
数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
说明:

 n 的范围是 [1, 1000] 并且 k 的范围是 [0, 1000]。
```


链接：https://leetcode-cn.com/problems/k-inverse-pairs-array

## 解题记录

+ 动态规划求解
+ $1..n$插入最大值其产生的逆序对最多为n个最小为0个
+ 通过$dp[i][j]$来表示$1..i$范围的有j个逆序对的情况
+ 这里需要对$i-1$情况中所有情况做加和

```java
/**
 * @author: ffzs
 * @Date: 2021/11/11 上午7:27
 */
public class Solution {
    static final int MOD = 1_000_000_007;
    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n+1][k+1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = 0; j <= k; j++) {
                sum += dp[i-1][j];
                if (j + 1 > i) sum -= dp[i-1][j-i];
                dp[i][j] = (dp[i][j] + sum) % MOD;
            }
        }
        return (int)dp[n][k];
    }
}
```

![image-20211111082038629](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211111082038629.png)

