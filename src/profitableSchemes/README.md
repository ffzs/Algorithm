## 879. 盈利计划

## 题目

集团里有 n 名员工，他们可以完成各种各样的工作创造利润。

第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。

工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。

有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。

 

```java
示例 1：

输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
输出：2
解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
总的来说，有两种计划。
示例 2：

输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
输出：7
解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。
```



```java
提示：

1 <= n <= 100
0 <= minProfit <= 100
1 <= group.length <= 100
1 <= group[i] <= 100
profit.length == group.length
0 <= profit[i] <= 100
```


链接：https://leetcode-cn.com/problems/profitable-schemes

## 解题记录

+  动态规划的背包算法
+ 本体的不同点是，应为利润大于等于最小利润的情况都要算上，因此在遍历minProfit时，不设置边界，需要计算大于minprofit的情况

```java
/**
 * @author: ffzs
 * @Date: 2021/6/9 上午7:03
 */
public class Solution {

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int MOD = 1_000_000_000 + 7;
        int[][] dp = new int[n+1][minProfit+1];
        dp[0][0] = 1;
        for (int i = 0; i < len; i++) {
            int g  = group[i], p = profit[i];
            for (int j = n; j >= g; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j-g][Math.max(0, k-p)])%MOD;
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= n; i++) {
            res = (res + dp[i][minProfit]) % MOD;
        }
        return res;
    }

    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int MOD = (int)1e9 + 7;
        int[][][] dp = new int[len+1][n+1][minProfit+1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if(j < group[i-1]) dp[i][j][k] = dp[i-1][j][k];
                    else {
                        dp[i][j][k] = (dp[i-1][j][k] + dp[i-1][j-group[i-1]][Math.max(0, k - profit[i-1])]) % MOD;
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i <= n; i++) {
            res = (res + dp[len][i][minProfit]) % MOD;
        }
        return res;
    }

}
```

![image-20210609075135954](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210609075135954.png)