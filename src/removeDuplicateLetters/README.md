## [316. 去除重复字母](https://leetcode-cn.com/problems/remove-duplicate-letters/)

## 题目

给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

```java
示例 1：

输入：s = "bcabc"
输出："abc"
示例 2：

输入：s = "cbacdcbc"
输出："acdb"
```



```java
提示：

1 <= s.length <= 104
s 由小写英文字母组成
```


链接：https://leetcode-cn.com/problems/remove-duplicate-letters

## 解题记录

+ 优先统计出每个字符出现的频率
+ 然后每添加一个字符都要看看是否之前的是否有比其大的并且不止一个的字符，如果有的话直接删去这些

```java
/**
 * @author: ffzs
 * @Date: 2020/12/20 上午11:50
 */
public class Solution2 {

    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] counter = new int[26];
        boolean[] pick = new boolean[26];

        for (char c : chars) counter[c-'a']++;
        int len = 0;

        for (int i : counter) {
            if (i > 0) len++;
        }

        char[] res = new char[len];
        int idx = 0;

        for (char cur : chars) {
            if (!pick[cur - 'a']) {
                while (idx > 0 && res[idx - 1] > cur) {
                    if (counter[res[idx - 1] - 'a'] > 0) {
                        pick[res[idx - 1] - 'a'] = false;
                        idx--;
                    } else {
                        break;
                    }
                }
                pick[cur - 'a'] = true;
                res[idx++] = cur;
            }
            counter[cur - 'a']--;
        }
        return new String(res);
    }
}
```

![image-20201220121937432](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201220121937432.png)