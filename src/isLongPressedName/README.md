## [925. 长按键入](https://leetcode-cn.com/problems/long-pressed-name/)

## 题目

你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。

你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。

```java
示例 1：

输入：name = "alex", typed = "aaleex"
输出：true
解释：'alex' 中的 'a' 和 'e' 被长按。
```

```java
示例 2：

输入：name = "saeed", typed = "ssaaedd"
输出：false
解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
```

```java
示例 3：

输入：name = "leelee", typed = "lleeelee"
输出：true
```

```java
示例 4：

输入：name = "laiden", typed = "laiden"
输出：true
解释：长按名字中的字符并不是必要的。
```

```java
提示：

name.length <= 1000
typed.length <= 1000
name 和 typed 的字符都是小写字母。
```


链接：https://leetcode-cn.com/problems/long-pressed-name

## 解题记录

+ 通过逐个比对字符，typed中字符可以是name中当前字符或者是当前字符前一个
+ 比对结束可能typed还剩一部分要和name的最后一个字符比较

```java
/**
 * @author: ffzs
 * @Date: 2020/10/21 上午7:05
 */
public class Solution {

    public boolean isLongPressedName(String name, String typed) {
        if (name.length() > typed.length() || name.charAt(0) != typed.charAt(0)) return false;
        int i = 1, j = 1;
        while (i<name.length() && j<typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;j++;
            }
            else if (name.charAt(i-1) == typed.charAt(j)) {
                j++;
            }
            else return false;
        }
        if (i != name.length()) return false;
        for (int k=j; k<typed.length(); k++) {
            if (name.charAt(i-1) != typed.charAt(k)) return false;
        }
        return true;
    }
}
```

![image-20201021072335576](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201021072335576.png)