## 87. 扰乱字符串

## 题目

使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
如果字符串的长度为 1 ，算法停止
如果字符串的长度 > 1 ，执行下述步骤：
在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。 

```java
示例 1：

输入：s1 = "great", s2 = "rgeat"
输出：true
解释：s1 上可能发生的一种情形是：
"great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
"gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
"gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
"g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
"r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
"r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
算法终止，结果字符串和 s2 相同，都是 "rgeat"
这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
示例 2：

输入：s1 = "abcde", s2 = "caebd"
输出：false
示例 3：

输入：s1 = "a", s2 = "a"
输出：true
```

```java
提示：

s1.length == s2.length
1 <= s1.length <= 30
s1 和 s2 由小写英文字母组成
```


链接：https://leetcode-cn.com/problems/scramble-string

## 解题记录

+ 通过动态规划记录每段匹配情况，通过一个三维数组`dp[i][j][len]`存储s1的子串：以i开始长度为len， 以及s2的子串：以j开始长度为len，存储这两个字符串是否相同，通过递归的方式进行分隔，最终是分隔到单个字符。

```java
/**
 * @author: ffzs
 * @Date: 2021/4/16 上午7:49
 */
public class Solution {

    int[][][] dp;
    char[] cs1, cs2;
    int n;
    public boolean isScramble(String s1, String s2) {
        cs1 = s1.toCharArray();
        cs2 = s2.toCharArray();
        n = cs1.length;
        dp = new int[n][n][n+1];
        return dfs(0, 0, n);
    }

    private boolean dfs (int i, int j, int len) {
        if (dp[i][j][len] != 0) return dp[i][j][len] == 1;

        if (arrayEquals(i,j,len)) {
            dp[i][j][len] = 1;
            return true;
        }

        int[] counter = new int[26];
        for (int k = 0; k < len; k++) {
            counter[cs1[i+k]-'a']++;
            counter[cs2[j+k]-'a']--;
        }
        for (int k : counter) {
            if (k != 0) {
                dp[i][j][len] = -1;
                return false;
            }
        }

        for (int k = 1; k < len; k++) {
            if (dfs(i,j,k) && dfs(i+k, j+k, len-k)) {
                dp[i][j][len] = 1;
                return true;
            }
            if (dfs(i,j + len-k, k) && dfs(i+k, j, len-k)) {
                dp[i][j][len] = 1;
                return true;
            }
        }
        dp[i][j][len] = -1;
        return false;
    }

    private boolean arrayEquals (int i, int j, int len) {
        for (int k = 0; k < len; k++) {
            if (cs1[i+k] != cs2[j+k]) return  false;
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        Solution s = new Solution();
        System.out.println(s.isScramble(s1, s2));
    }
}
```

![image-20210416095312194](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210416095312194.png)