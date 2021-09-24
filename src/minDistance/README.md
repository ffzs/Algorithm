## 583. 两个字符串的删除操作

## 题目

给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。

 

```java
示例：

输入: "sea", "eat"
输出: 2
解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
```



```java
提示：

给定单词的长度不超过500。
给定单词中的字符只含有小写字母。
```


链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings

## 解题记录

+ 通过动态规划求出两个字符串的最长子序列长度
+ 然后再求出变化使用的步数

```java
/**
 * @author: ffzs
 * @Date: 2021/9/25 上午6:44
 */
public class Solution {

    public int minDistance(String word1, String word2) {
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();

        int m = cs1.length, n = cs2.length;

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            char c1 = cs1[i-1];
            for (int j = 1; j <= n; j++) {
                char c2 = cs2[j-1];
                if (c1 == c2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        int len = dp[m][n];
        return m + n - 2*len;
    }

}
```

![image-20210925065509828](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210925065509828.png)