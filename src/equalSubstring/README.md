## [1208. 尽可能使字符串相等](https://leetcode-cn.com/problems/get-equal-substrings-within-budget/)

## 题目

给你两个长度相同的字符串，s 和 t。

将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。

用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。

如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。

如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。

```java
示例 1：

输入：s = "abcd", t = "bcdf", cost = 3
输出：3
解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
示例 2：

输入：s = "abcd", t = "cdef", cost = 3
输出：1
解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
示例 3：

输入：s = "abcd", t = "acde", cost = 0
输出：1
解释：你无法作出任何改动，所以最大长度为 1。
```

```java
提示：

1 <= s.length, t.length <= 10^5
0 <= maxCost <= 10^6
s 和 t 都只含小写英文字母。
```


链接：https://leetcode-cn.com/problems/get-equal-substrings-within-budget

## 解题记录

+ 问题可以转化为柱条，求面积
+ 首先通过字符串只差的绝对值获取高度
+ 然后通过移动窗口获取一段距离的面积之和，然后缓存最大值
+ 面积小于cost，右移，面积大于左移

```java
/**
 * @author: ffzs
 * @Date: 2021/2/5 上午8:40
 */
public class Solution {

    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            tmp[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int res = 0, sum = 0;
        int left = 0, right = 0;
        while (right < n) {
            if (sum + tmp[right] <= maxCost) {
                sum += tmp[right];
                res = Math.max(res, right - left + 1);
                right ++;
            }
            else {
                sum -= tmp[left++];
            }
        }
        return res;
    }
}

class Test{
    public static void main(String[] args) {
        String s = "abcd";
        String t = "cdef";
        Solution solution = new Solution();
        System.out.println(solution.equalSubstring(s, t, 3));
    }
}
```

![image-20210205094232030](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210205094232030.png)

