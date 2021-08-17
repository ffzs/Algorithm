## 552. 学生出勤记录 II

## 题目

可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
'A'：Absent，缺勤
'L'：Late，迟到
'P'：Present，到场
如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：

按 总出勤 计，学生缺勤（'A'）严格 少于两天。
学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。

 

```java
示例 1：

输入：n = 2
输出：8
解释：
有 8 种长度为 2 的记录将被视为可奖励：
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL" 
只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
示例 2：

输入：n = 1
输出：3
示例 3：

输入：n = 10101
输出：183236316
```



```java
提示：

1 <= n <= 105
```

链接：https://leetcode-cn.com/problems/student-attendance-record-ii

## 解题记录

+ 回溯
+ 超时

```java
/**
 * @author: ffzs
 * @Date: 2021/8/18 上午6:54
 * 1: A
 * 2: L
 * 3: P
 */
public class Solution {

    int res = 0;
    public int checkRecord(int n) {
        int[] tmp = new int[n];
        dfs(tmp, 0, 0);
        return res;
    }


    private void dfs(int[] t, int i, int A){
        if (A >= 2 || (i-2>0 && t[i-1] == 2 && t[i-2] == 2 && t[i-3] == 2)) return;
        if (i == t.length){
            res ++;
            return;
        }

        for (int j = 1; j <= 3; j++) {
            t[i] = j;
            dfs(t, i + 1, j == 1? A+1 : A);
        }
    }

}
```

+ 动态规划，通过记录各种状态情况，进行累加

```java
/**
 * @author: ffzs
 * @Date: 2021/8/18 上午7:09
 */
public class Solution2 {

    public int checkRecord(int n) {
        final int MOD = 1_000_000_007;
        int[][][] dp = new int[n+1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % MOD;
                }
            }

            for (int k = 0; k < 3; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][k]) % MOD;
            }

            for (int j = 0; j < 2; j++) {
                for (int k = 1; k < 3; k++) {
                    dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % MOD;
                }
            }
        }

        int res = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                res = (res + dp[n][j][k]) % MOD;
            }
        }
        return res;
    }

}
```



```java
class Solution {
    /*
     * AA 有A，且末尾为A
     * AP 有A，且末尾为P
     * AL 有A，且末尾为L
     * ALL 有A，且末尾为LL
     * P 无A，末尾为P
     * L 无A，末尾为L
     * LL 无A，末尾为LL
     */
    public int checkRecord(int n) {
        long AA = 1,AP = 0,AL = 0,ALL = 0,P = 1,L = 1,LL = 0;
        long mod = 1000000007;
        for (int i = 1; i < n; i++) {
            long aa = (P + L + LL)%mod;
            long ap = (AA + AP + AL + ALL)%mod;
            long al = (AA + AP)%mod;
            long all = AL;
            long p = (P + L + LL)%mod;
            long l = P;
            long ll = L;
            AA = aa;AP = ap;AL = al;ALL = all;P = p;L = l;LL = ll;
        }
        return (int)((AA + AP + AL + ALL + P + L + LL)%mod);
    }
}
```

![image-20210818072643798](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210818072643798.png)