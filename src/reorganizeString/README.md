## [767. 重构字符串](https://leetcode-cn.com/problems/reorganize-string/)

## 题目

给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。

若可行，输出任意可行的结果。若不可行，返回空字符串。

```java
示例 1:

输入: S = "aab"
输出: "aba"
示例 2:

输入: S = "aaab"
输出: ""
```

注意:

S 只包含小写字母并且长度在[1, 500]区间内。


链接：https://leetcode-cn.com/problems/reorganize-string

## 解题记录

+ 优先统计每个字符出现情况，如果出现某个字符的长度超过一半那么不能分隔
+ 如果没有超过的情况，那么需要构建新的字符串
+ 每个循环添加一个不同于前一个的数量最多的那个字符

```java
/**
 * @author: ffzs
 * @Date: 2020/11/30 上午7:15
 */

public class Solution {
    public String reorganizeString(String S) {
        char[] cs = S.toCharArray();
        int[] counter = new int[26];

        for (char c : cs) {
            counter[c-'a']++;
            if (counter[c-'a']>(cs.length+1)/2) return "";
        }

        int pre = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            int max = 0, idx=0;
            for (int j = 0; j < counter.length; j++) {
                if (counter[j] > max && j != pre) {
                    max = counter[j];
                    idx = j;
                }
            }
            sb.append((char)(idx + 'a'));
            counter[idx]--;
            pre = idx;
        }
        return sb.toString();
    }
}
```

![image-20201130074631014](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201130074631014.png)