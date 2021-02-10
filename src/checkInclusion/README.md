## [567. 字符串的排列](https://leetcode-cn.com/problems/permutation-in-string/)

## 题目

给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

```java
示例1:
输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").

示例2:
输入: s1= "ab" s2 = "eidboaoo"
输出: False
```



```java
注意：

输入的字符串只包含小写字母
两个字符串的长度都在 [1, 10,000] 之间
```


链接：https://leetcode-cn.com/problems/permutation-in-string

## 解题记录

+ 原理很简单，就是通过比较窗口中的所有值得count是否一致即可
+ 这里通过双指针进行处理，counter大于0的话left一直移动，直到出现长度和s1相同

```java
/**
 * @author: ffzs
 * @Date: 2021/2/10 上午9:31
 */
public class Solution {

    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        if (c1.length > c2.length) return false;

        int[] counter = new int[26];

        for (char c : c1) counter[c - 'a']++;

        int left = 0, right = 0;

        while (right < c2.length) {
            int cur = c2[right] - 'a';
            counter[cur]--;
            while (counter[cur] < 0 ) {
                counter[c2[left++] - 'a']++;
            }
            if (right - left + 1 == c1.length) return true;
            right++;
        }
        return false;
    }
}
```

![image-20210210095713492](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210210095713492.png)