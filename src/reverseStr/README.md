## 541. 反转字符串 II

## 题目

给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。

```java
示例 1：

输入：s = "abcdefg", k = 2
输出："bacdfeg"
示例 2：

输入：s = "abcd", k = 2
输出："bacd"
```



```java
提示：

1 <= s.length <= 104
s 仅由小写英文组成
1 <= k <= 104
```


链接：https://leetcode-cn.com/problems/reverse-string-ii

## 解题记录

+ 双指针，优先限定区域，然后交换

```java
/**
 * @author: ffzs
 * @Date: 2021/8/20 上午6:52
 */
public class Solution {

    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        for (int a = 0; a < n; a += 2*k) {
            int i = a;
            int j = Math.min(i+k-1, n-1);
            System.out.println(i+":"+j);
            while (i < j) {
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(cs);
    }

}
```

![image-20210820071433015](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210820071433015.png)