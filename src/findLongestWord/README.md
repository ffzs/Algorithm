## 524. 通过删除字母匹配到字典里最长单词

## 题目

给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。

如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。

 

```java
示例 1：

输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
输出："apple"
示例 2：

输入：s = "abpcplea", dictionary = ["a","b","c"]
输出："a"
```



```java
提示：

1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s 和 dictionary[i] 仅由小写英文字母组成
```


链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting

## 解题记录

+ 通过双指针进行比对
+ 两个字符串同时移动，s可以跳过一些字符，如果完全匹配的上即为符合条件
+ 通过排序从长到短进行匹配

```java
/**
 * @author: ffzs
 * @Date: 2021/9/14 上午6:48
 */
public class Solution {

    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a,b)-> {
            if (a.length() != b.length()) return b.length() - a.length();
            else return a.compareTo(b);
        });

        for (String d : dictionary) {
            int i = 0, j = 0;
            while (i < d.length() && j < s.length()) {
                if (d.charAt(i) == s.charAt(j)) i++;
                j++;
            }
            if (i == d.length()) return d;
        }
        return "";
    }

}
```

![image-20210914071535965](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210914071535965.png)