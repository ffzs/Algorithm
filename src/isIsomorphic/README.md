## [205. 同构字符串](https://leetcode-cn.com/problems/isomorphic-strings/)

## 题目

给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

```java
示例 1:
输入: s = "egg", t = "add"
输出: true

示例 2:
输入: s = "foo", t = "bar"
输出: false

示例 3:
输入: s = "paper", t = "title"
输出: true

说明:
你可以假设 s 和 t 具有相同的长度。
```

链接：https://leetcode-cn.com/problems/isomorphic-strings



## 解题记录

+ 用两个map做映射
+ 如果映射的不是一个，就直接返回false

```java
/**
 * @author: ffzs
 * @Date: 2020/12/27 上午10:10
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[128];
        int[] remap = new int[128];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();

        for (int i = 0; i < sc.length; i++) {
            int c1 = sc[i];
            int c2 = tc[i];
            if (map[c1] == 0 && remap[c2] == 0) {
                map[c1] = c2;
                remap[c2] = c1;
            }
            else {
                if (map[c1] != c2 | remap[c2] != c1) return false;
            }
        }

        return true;
    }
}
```

![image-20201227104232781](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201227104232781.png)