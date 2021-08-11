## 516. 最长回文子序列

## 题目

给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。

子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。

 

```java
示例 1：

输入：s = "bbbab"
输出：4
解释：一个可能的最长回文子序列为 "bbbb" 。
示例 2：

输入：s = "cbbd"
输出：2
解释：一个可能的最长回文子序列为 "bb" 。
```



```java
提示：

1 <= s.length <= 1000
s 仅由小写英文字母组成
```


链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence

## 解题记录

+ 通过动态规划求解
+ `dp[i][j]` 表示`[i...j]`区间内的回文数情况
+ 由于单个字符也算是回文因此`i==j`的时候都是1
+ 如果`s[i]==s[j]`那么回文长度增加2
+ 不然的话继承`i+1 or j-1`中的一个

```java
/**
 * @author: ffzs
 * @Date: 2021/8/12 上午6:50
 */
public class Solution {

    public int longestPalindromeSubseq(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        if (n <= 1) return n;

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (cs[i] == cs[j]) dp[i][j] = dp[i+1][j-1] + 2;
                else dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
            }
        }
        return dp[0][n-1];
    }

}
```

![image-20210812071022344](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210812071022344.png)