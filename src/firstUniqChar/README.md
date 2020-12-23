## [387. 字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string/)

## 题目

给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

 

```java
示例：

s = "leetcode"
返回 0

s = "loveleetcode"
返回 2


提示：你可以假定该字符串只包含小写字母。
```




链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string

## 解题记录

+ 先统计个数
+ 然后返回第一个只有一个的索引

```java
/**
 * @author: ffzs
 * @Date: 2020/12/23 上午8:25
 */
public class Solution {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] counter = new int[26];

        for (char c : chars) {
            counter[c-'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (counter[chars[i]-'a'] == 1) return i;
        }

        return -1;
    }

}
```

![image-20201223083612850](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201223083612850.png)