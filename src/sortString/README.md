## [1370. 上升下降字符串](https://leetcode-cn.com/problems/increasing-decreasing-string/)

## 题目

给你一个字符串 s ，请你根据下面的算法重新构造字符串：

1. 从s中选出最小的字符，将它接在结果字符串的后面。
1. 从s剩余字符中选出 最小的字符，且该字符比上一个添加的字符大，将它接在结果字符串后面。
1. 重复步骤2，直到你没法从s中选择字符。
1. 从s中选出 最大的字符，将它接在结果字符串的后面。
1. 从s剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它接在结果字符串后面。
1. 重复步骤5，直到你没法从 s 中选择字符。
1. 重复步骤1到6，直到 s 中所有字符都已经被选过。
1. 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。

请你返回将 s 中字符重新排序后的 结果字符串 。


```java
示例 1：

输入：s = "aaaabbbbcccc"
输出："abccbaabccba"
解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
示例 2：

输入：s = "rat"
输出："art"
解释：单词 "rat" 在上述算法重排序以后变成 "art"
示例 3：

输入：s = "leetcode"
输出："cdelotee"
示例 4：

输入：s = "ggggggg"
输出："ggggggg"
示例 5：

输入：s = "spo"
输出："ops"
```

提示：

1 <= s.length <= 500
s 只包含小写英文字母。


链接：https://leetcode-cn.com/problems/increasing-decreasing-string

## 解题记录

+ 优先统计出字符串中每一个字符出现的次数
+ 然后正向逆向循环数组获取字符添加到支付串中

```java
/**
 * @author: ffzs
 * @Date: 2020/11/25 上午7:34
 */
public class Solution {
    StringBuilder sb = new StringBuilder();
    public String sortString(String s) {
        char[] chars = s.toCharArray();
        int[] counter = new int[26];
        for (char c : chars) {
            counter[c-'a']++;
        }
        add(counter, chars.length, 0);
        return sb.toString();
    }

    private void add (int[] counter, int len, int dir) {
        if (dir == 0) {
            for (int i = 0; i < counter.length; i++) {
                if (counter[i] != 0) {
                    sb.append((char)(i+'a'));
                    counter[i]--;
                    len--;
                }
            }
            if (len > 0) add(counter, len, 1);
        }
        else {
            for (int i = counter.length - 1; i >= 0; i--) {
                if (counter[i] != 0) {
                    sb.append((char)(i+'a'));
                    counter[i]--;
                    len--;
                }
            }
            if (len > 0) add(counter, len, 0);
        }
    }
}
```

![image-20201125075813616](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201125075813616.png)