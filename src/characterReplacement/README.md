## [424. 替换后的最长重复字符](https://leetcode-cn.com/problems/longest-repeating-character-replacement/)

## 题目

给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。

注意：字符串长度 和 k 不会超过 104。

```java
示例 1：

输入：s = "ABAB", k = 2
输出：4
解释：用两个'A'替换为两个'B',反之亦然。
示例 2：

输入：s = "AABABBA", k = 1
输出：4
解释：
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。
```


链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement



## 解题记录

+ 通过移动窗口处理
+ 动态移动窗口右侧，一边维护窗口中的所有类型的字符个数
+ 通过判断最多的那个字符之外其他字符出现的数量是否大于k来判断是否还在范围之内
+ 如果不在范围之内的话串口左侧右移

```java
/**
 * @author: ffzs
 * @Date: 2021/2/2 上午9:55
 */
public class Solution {

    public int characterReplacement(String s, int k) {
        int[] counter = new int[26];
        char[] c = s.toCharArray();
        int n = c.length;
        int max = 0;
        int left = 0, right = 0;

        while (right < n) {
            counter[c[right] - 'A'] ++;
            max = Math.max(max, counter[c[right] - 'A']);
            if (right - left + 1 - max > k) {
                counter[c[left] - 'A'] --;
                left ++;
            }
            right ++;
        }
        return right - left;
    }

}
```

![image-20210202112951287](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210202112951287.png)