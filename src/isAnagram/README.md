## [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/)

## 题目

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

```java
示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
    
说明:
你可以假设字符串只包含小写字母。
```

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？


链接：https://leetcode-cn.com/problems/valid-anagram

## 解题记录

+ 通过一个数组记录小写字符的个数
+ 然后通过比对另一个字符来确定是否都能对应得上

```java
/**
 * @author: ffzs
 * @Date: 2020/11/22 上午11:09
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counter = new int[26];
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        for (char c : cs) {
            counter[c-'a']++;
        }
        for (char c : ts) {
            counter[c-'a']--;
            if (counter[c-'a'] < 0) return false;
        }
        return true;
    }
}
```

![image-20201122113127991](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201122113127991.png)