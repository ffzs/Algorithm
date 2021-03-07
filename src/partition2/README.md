## [131. 分割回文串](https://leetcode-cn.com/problems/palindrome-partitioning/)

## 题目

给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

```java
示例:

输入: "aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]
```


链接：https://leetcode-cn.com/problems/palindrome-partitioning

## 解题记录

+ 通过一个二维数组来存储起始和终止位置时是否为回文

+ 通过回溯算法获取全部的配对情况

  

```java
/**
 * @author: ffzs
 * @Date: 2021/3/7 下午1:40
 */
public class Solution {
    int[][] f;
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    int n;


    public List<List<String>> partition(String s) {
        n = s.length();
        f = new int[n][n];

        dfs(s, 0);

        return res;
    }

    private void dfs(String s, int i) {
        if (i == n) {
            res.add(new ArrayList<>(list));
        }
        else {
            for (int j = i; j < n; j++) {
                if (isValid(s, i, j) == 1) {
                    list.add(s.substring(i, j + 1));
                    dfs(s, j + 1);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private int isValid(String s, int i, int j) {
        if (f[i][j] != 0) return f[i][j];

        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isValid(s, i + 1, j - 1);
        } else f[i][j] = -1;
        
        return f[i][j];
    }

}
```

![image-20210307142223685](README.assets/image-20210307142223685.png)