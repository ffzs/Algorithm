## 168. Excel表列名称

## 题目

给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，

```java
1 -> A
2 -> B
3 -> C
...
26 -> Z
27 -> AA
28 -> AB 
...
```
```java
示例 1:
输入: 1
输出: "A"
    
示例 2:
输入: 28
输出: "AB"
    
示例 3:
输入: 701
输出: "ZY"
```


链接：https://leetcode-cn.com/problems/excel-sheet-column-title

## 解题记录

+ 26进制
+ 通过叠除获取字符，然后翻转即可

```java
/**
 * @author: ffzs
 * @Date: 2021/6/29 上午6:54
 */
public class Solution {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber >= 1) {
            int x = (columnNumber - 1)%26 + 1;
            sb.append((char)(x - 1 + 'A'));
            columnNumber = (columnNumber - x) / 26;
        }

        return sb.reverse().toString();
    }
}

class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertToTitle(701));
    }
}
```

![image-20210629071753910](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210629071753910.png)