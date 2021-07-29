## 171. Excel表列序号

## 题目

给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
```java
示例 1:

输入: "A"
输出: 1
示例 2:

输入: "AB"
输出: 28
示例 3:

输入: "ZY"
输出: 701
致谢：
特别感谢 @ts 添加此问题并创建所有测试用例。
```


链接：https://leetcode-cn.com/problems/excel-sheet-column-number

## 解题记录

+ 可以理解为26进制的逆计算

```java
/**
 * @author: ffzs
 * @Date: 2021/7/30 上午6:58
 * 26进制
 */
public class Solution {

    public int titleToNumber(String columnTitle) {
        char[] cs = columnTitle.toCharArray();

        int res = 0;
        for (char c : cs) {
            res *= 26;
            res += c - 'A' + 1;
        }
        return res;
    }

}
```

![image-20210730074537224](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210730074537224.png)