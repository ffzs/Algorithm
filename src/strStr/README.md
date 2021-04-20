## 28. 实现 strStr()

## 题目

实现 strStr() 函数。

给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。

说明：

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。

```java
示例 1：

输入：haystack = "hello", needle = "ll"
输出：2
示例 2：

输入：haystack = "aaaaa", needle = "bba"
输出：-1
示例 3：

输入：haystack = "", needle = ""
输出：0
```



```java
提示：

0 <= haystack.length, needle.length <= 5 * 104
haystack 和 needle 仅由小写英文字符组成
```



链接：https://leetcode-cn.com/problems/implement-strstr



## 解题记录

+ 直接通过循环遍历haystack，然后如果有字符和needle第一个字符相同，那么进行比较是否完全一致



```java
/**
 * @author: ffzs
 * @Date: 2021/4/20 上午8:23
 */
public class Solution2 {
    public int strStr(String haystack, String needle) {
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        if (n.length == 0) return 0;

        for (int i = 0; i < h.length - n.length + 1; i++) {
            m:if (h[i] == n[0]) {
                for (int j = 1; j < n.length; j++) {
                    if (n[j] != h[i+j]) break m;
                }
                return i;
            }
        }

        return -1;
    }
}
```

![image-20210420083050048](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210420083050048.png)