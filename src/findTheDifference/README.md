## [389. 找不同](https://leetcode-cn.com/problems/find-the-difference/)

## 题目

给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。 

```java
示例 1：

输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。
示例 2：

输入：s = "", t = "y"
输出："y"
示例 3：

输入：s = "a", t = "aa"
输出："a"
示例 4：

输入：s = "ae", t = "aea"
输出："a"
```

```java
提示：

0 <= s.length <= 1000
t.length == s.length + 1
s 和 t 只包含小写字母
```


链接：https://leetcode-cn.com/problems/find-the-difference

## 解题记录

+ 直接计数s，然后比对t中字符

```java
/**
 * @author: ffzs
 * @Date: 2020/12/18 上午8:00
 */
public class Solution {

    public char findTheDifference(String s, String t) {
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            int at = t.charAt(i) - 'a';
            if (counter[at] > 0) counter[at]--;
            else return t.charAt(i);
        }

        return 'a';
    }
}
```

![image-20201218081229315](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201218081229315.png)

+ 通过异或求，两个序列中没有配对的字符就是后添加的字符

```java
/**
 * @author: ffzs
 * @Date: 2020/12/18 上午8:07
 */
public class Solution2 {
    public char findTheDifference(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        char res = tc[tc.length-1];
        for (int i = 0; i < sc.length; i++) {
            res ^= sc[i];
            res ^= tc[i];
        }
        return res;
    }
}
```

![image-20201218081508153](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201218081508153.png)