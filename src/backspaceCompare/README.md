## [844. 比较含退格的字符串](https://leetcode-cn.com/problems/backspace-string-compare/)

## 题目

给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。

注意：如果对空文本输入退格字符，文本继续为空。



```java
示例 1：

输入：S = "ab#c", T = "ad#c"
输出：true
解释：S 和 T 都会变成 “ac”。
```

```java
示例 2：

输入：S = "ab##", T = "c#d#"
输出：true
解释：S 和 T 都会变成 “”。
```

```java
示例 3：

输入：S = "a##c", T = "#a#c"
输出：true
解释：S 和 T 都会变成 “c”。
```

```java
示例 4：

输入：S = "a#c", T = "b"
输出：false
解释：S 会变成 “c”，但 T 仍然是 “b”。
```


提示：

1 <= S.length <= 200
1 <= T.length <= 200
S 和 T 只含有小写字母以及字符 '#'。


进阶：

你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？


链接：https://leetcode-cn.com/problems/backspace-string-compare

## 解题记录

+ 按照规则进行处理字符串，最终比对

```java
/**
 * @author: ffzs
 * @Date: 2020/10/19 上午8:47
 */
public class Solution {

    public boolean backspaceCompare(String S, String T) {
        return deal(S).toString().equals(deal(T).toString());
    }

    private StringBuilder deal (String str) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                if (sb.length()>0) sb.deleteCharAt(sb.length()-1);
            }
            else sb.append(str.charAt(i));
        }
        System.out.println(sb);
        return sb;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("ab##", "c#d#"));
//        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));

    }
}
```

![image-20201019115603546](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201019115603546.png)