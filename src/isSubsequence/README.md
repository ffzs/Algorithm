## [392. 判断子序列](https://leetcode-cn.com/problems/is-subsequence/)

## 题目

给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

```java
示例 1:
s = "abc", t = "ahbgdc"

返回 true.
```

```java
示例 2:
s = "axc", t = "ahbgdc"

返回 false.
```

```java
后续挑战 :

如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
```


链接：https://leetcode-cn.com/problems/is-subsequence

## 解题记录

+ 直接对两个序列进行逐个比较
+ 如果s序列中的所有t中都能比对的上，则返回true

```java
/**
 * @author: ffzs
 * @Date: 2020/7/27 上午8:03
 */
public class Solution {
    public static boolean isSubsequence(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int i = 0, j = 0;
        while (i < sc.length && j < tc.length) {
            if (sc[i] == tc[j]) i++;
            j++;
        }
        return i == sc.length;
    }

    public static void main(String[] args) {
        String s = "aaaaaa", t = "bbaaaa";
        System.out.println(isSubsequence(s, t));
    }
}

```

![image-20200727082522866](README.assets/image-20200727082522866.png)