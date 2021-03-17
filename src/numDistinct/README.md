## [115. 不同的子序列](https://leetcode-cn.com/problems/distinct-subsequences/)

## 题目

给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。

字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）

题目数据保证答案符合 32 位带符号整数范围。

 

```java
示例 1：

输入：s = "rabbbit", t = "rabbit"
输出：3
解释：
如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
(上箭头符号 ^ 表示选取的字母)
rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
示例 2：

输入：s = "babgbag", t = "bag"
输出：5
解释：
如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
(上箭头符号 ^ 表示选取的字母)
babgbag
^^ ^
babgbag
^^    ^
babgbag
^ ^         ^
babgbag
   ^      ^^
babgbag
         ^^^
```

```java
提示：

0 <= s.length, t.length <= 1000
s 和 t 由英文字母组成
```


链接：https://leetcode-cn.com/problems/distinct-subsequences

## 解题记录

+ 通过回溯算法求解

```java
/**
 * @author: ffzs
 * @Date: 2021/3/17 上午7:23
 */
public class Solution {

    char[] tc, sc, tmp;
    int n;
    int res = 0;
    public int numDistinct(String s, String t) {
        sc = s.toCharArray();
        tc = t.toCharArray();
        n = tc.length;
        tmp = new char[n];

        dfs(0, 0);

        return res;
    }

    private void dfs(int i, int c) {
        if (c >= n) {
            if (equal(tmp, tc)) res ++;
            return;
        }

        for (int j = i; j < sc.length; j++) {
            if(sc[j] == tc[c]) {
                tmp[c] = sc[j];
                dfs(j + 1, c + 1);
            }
        }
    }


    private boolean equal (char[] a, char[] b) {
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
```

![image-20210317075158390](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210317075158390.png)

一些相同元素的判断太费时间，其实可以压缩相邻相同字符，然后通过组合求最大

+ 动态规划
+ 通过记录dp，s中前i项匹配t中前j项个数
+ 入过s[i] 和 t[j]相同，那么总数加上$dp[i-1][j-1]$的值，不然直接跳过

```java
/**
 * @author: ffzs
 * @Date: 2021/3/17 上午7:53
 */
public class Solution2 {

    public int numDistinct(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int m = sc.length, n = tc.length;
        if (m < n) return 0;

        int[][] f = new int[m+1][n+1];
        for (int[] ints : f) {
            ints[n] = 1;
        }

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                f[i][j] = sc[i] == tc[j]?f[i+1][j+1] + f[i+1][j]:f[i+1][j];
            }
        }

        return f[0][0];
    }

}
```

![image-20210317081858877](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210317081858877.png)