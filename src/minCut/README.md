## [132. 分割回文串 II](https://leetcode-cn.com/problems/palindrome-partitioning-ii/)

## 题目

给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。

返回符合要求的 最少分割次数 。

 

```java
示例 1：

输入：s = "aab"
输出：1
解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
示例 2：

输入：s = "a"
输出：0
示例 3：

输入：s = "ab"
输出：1
```



```java
提示：

1 <= s.length <= 2000
s 仅由小写英文字母组成
```


链接：https://leetcode-cn.com/problems/palindrome-partitioning-ii



## 解题记录

+ 通过使用回溯，一边切割一边判断是不是回文，同时通过一个数组记录下是否为回文

```java
/**
 * @author: ffzs
 * @Date: 2021/3/8 上午8:12
 */
public class Solution {

    int[][] f;
    int res = Integer.MAX_VALUE;
    int counter = 0;
    int n;

    public int minCut(String s) {
        n = s.length();
        f = new int[n][n];

        dfs(s, 0);
        return res -1;
    }

    private void dfs(String s, int i) {
        if (i == n) {
            res = Math.min(res, counter);
        }
        else {
            for (int j = n-1; j >= i; j--) {
                if (isValid(s, i, j) == 1 && counter < res) {
                    counter++;
                    dfs(s, j+1);
                    counter--;
                }
            }
        }
    }

    private int isValid(String s, int i, int j) {
        if (f[i][j] != 0) return f[i][j];

        if (i >= j) {
            f[i][j] = 1;
        }
        else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isValid(s, i+1, j-1);
        }
        else {
            f[i][j] = -1;
        }

        return f[i][j];
    }

}
```

但是效率比较低，超时了

![image-20210308084113495](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210308084113495.png)

+ 通过两次dp处理
+ 第一次dp获取i~j范围是否为回文
+ 第二次dp获取最小的分隔情况

```java
/**
 * @author: ffzs
 * @Date: 2021/3/8 上午8:41
 */
public class Solution2 {

    public int minCut(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        boolean[][] f = new boolean[n][n];
        for (boolean[] it : f) {
            Arrays.fill(it, true);
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                f[i][j] = cs[i] == cs[j] && f[i+1][j-1];
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, n-1);
        for (int i = 0; i < n; i++) {
            if (f[0][i]) dp[i] = 1;
            else {
                for (int j = 0; j < i; j++) {
                    if (f[i][j]) {
                        dp[i] = Math.min(dp[i], dp[j-1] +1);
                    }
                }
            }
        }

        return dp[n-1]-1;
    }

}
```

![image-20210308092349671](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210308092349671.png)