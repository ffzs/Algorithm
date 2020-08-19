## [647. 回文子串](https://leetcode-cn.com/problems/palindromic-substrings/)

## 题目

给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

```java
 示例 1：

输入："abc"
输出：3
解释：三个回文子串: "a", "b", "c"
```

```java
示例 2：

输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
```

```java
提示：

输入的字符串长度不会超过 1000 。
```


链接：https://leetcode-cn.com/problems/palindromic-substrings



## 解题记录

+ 通过中心扩展来找回文子串
+ 不过要对回文是奇数还是偶数进行区分

```java
/**
 * @author: ffzs
 * @Date: 2020/8/19 上午8:08
 */
public class Solution {
    public int countSubstrings(String s) {
        char[] seq = s.toCharArray();
        int n = seq.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int count = 0, left, right;

        for (int i = 1; i < n-1; ++i) {
                // 奇数
            left = right = i;
            while (left >= 0 && right<n && seq[left--] == seq[right++]) {
                count++;
            }
            // 偶数
            left = i;
            right = i+1;
            while (left >= 0 && right<n && seq[left--] == seq[right++]) {
                count++;
            }
        }
        return count;
    }
}
```

![image-20200819083619911](README.assets/image-20200819083619911.png)