## 58. 最后一个单词的长度

## 题目

给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。

单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

 

```java
示例 1：

输入：s = "Hello World"
输出：5
示例 2：

输入：s = "   fly me   to   the moon  "
输出：4
示例 3：

输入：s = "luffy is still joyboy"
输出：6
```



```java
提示：

1 <= s.length <= 104
s 仅有英文字母和空格 ' ' 组成
s 中至少存在一个单词
```


链接：https://leetcode-cn.com/problems/length-of-last-word

## 解题记录

+ 看清题目，要求的是最后一个单词

```java
/**
 * @author: ffzs
 * @Date: 2021/9/21 上午6:55
 */
public class Solution {

    public int lengthOfLastWord(String s) {
        char[] cs = s.toCharArray();
        int cnt = 0;
        for (int i = cs.length - 1; i >= 0; i--) {
            if (cs[i] != ' ') cnt++;
            else if (cnt != 0) return cnt;
        }
        return cnt;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLastWord("Today is a nice day"));
    }
}
```

![image-20210921071400269](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210921071400269.png)