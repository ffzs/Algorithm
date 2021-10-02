## 166. 分数到小数

## 题目

给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。

如果小数部分为循环小数，则将循环的部分括在括号内。

如果存在多个答案，只需返回 任意一个 。

对于所有给定的输入，保证 答案字符串的长度小于 104 。

```java
示例 1：

输入：numerator = 1, denominator = 2
输出："0.5"
示例 2：

输入：numerator = 2, denominator = 1
输出："2"
示例 3：

输入：numerator = 2, denominator = 3
输出："0.(6)"
示例 4：

输入：numerator = 4, denominator = 333
输出："0.(012)"
示例 5：

输入：numerator = 1, denominator = 5
输出："0.2"
```



```java
提示：

-231 <= numerator, denominator <= 231 - 1
denominator != 0
```


链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal

## 解题记录

+ 本别处理整数部分和小数部分
+ 小数部分的话可以通过hash记录index，有重复的情况下，通过index添加括号即可
+ 注意转化为long，不然的话会溢出

```java
/**
 * @author: ffzs
 * @Date: 2021/10/3 上午7:06
 */
public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        long num = numerator, den = denominator;
        boolean sign =(num * den) > 0;
        num = Math.abs(num);
        den = Math.abs(den);

        long before = num / den;
        long rem = num % den;

        StringBuilder res = new StringBuilder();
        if (!sign) res.append("-");
        res.append(before);
        if (rem == 0) return res.toString();
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (rem != 0 && !map.containsKey(rem)) {
            map.put(rem, index++);
            sb.append(rem * 10 /den);
            rem = rem * 10 % den;
        }
        if (rem != 0) {
            sb.insert(map.get(rem), "(").append(")");
        }
        return res.append(sb).toString();
    }

}
```

![image-20211003075205570](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211003075205570.png)