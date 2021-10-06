## 434. 字符串中的单词数

## 题目

统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。

请注意，你可以假定字符串里不包括任何不可打印的字符。

示例:

输入: "Hello, my name is John"
输出: 5
解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。


链接：https://leetcode-cn.com/problems/number-of-segments-in-a-string

## 解题记录

+ 优先split切割字符串，然后统计不为空的个数

```java
/**
 * @author: ffzs
 * @Date: 2021/10/7 上午6:16
 */

public class Solution {

    public int countSegments(String s) {
        return (int) Arrays.stream(s.split(" ")).filter(it -> !it.equals("")).count();
    }

}
```

![image-20211007063516028](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211007063516028.png)

