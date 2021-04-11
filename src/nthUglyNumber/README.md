## 264. 丑数 II

## 题目

给你一个整数 n ，请你找出并返回第 n 个 丑数 。

丑数 就是只包含质因数 2、3 和/或 5 的正整数。

```java
示例 1：

输入：n = 10
输出：12
解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
示例 2：

输入：n = 1
输出：1
解释：1 通常被视为丑数。
```

```java
提示：
1 <= n <= 1690
```

链接：https://leetcode-cn.com/problems/ugly-number-ii

## 解题记录

+ 因为要想获取只包含2，3，5因数的列表的话，那么最好的方式就是通过2，3，5相乘获取
+ 这里有一个问题就是要保持列表的递增，那么可以通过使用三个指针定位`*2,*3,*5`三种情况
+ 然后通过比较大小获取最小的情况，然后指针后移一位

```java
/**
 * @author: ffzs
 * @Date: 2021/4/11 上午8:37
 */
public class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int i = 1, j = 1, k = 1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int l = 2; l < n+1; l++) {
            dp[l] = Math.min(dp[i]*2, Math.min(dp[j]*3, dp[k]*5));
            if (dp[l] == dp[i]) i++;
            if (dp[l] == dp[j]) j++;
            if (dp[l] == dp[k]) k++;
        }
        return dp[n];
    }
}
```

![image-20210411094542003](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210411094542003.png)