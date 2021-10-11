## 29. 两数相除

## 题目

给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

```java
示例 1:
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
    
示例 2:
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2
```

```java
提示：

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
```


链接：https://leetcode-cn.com/problems/divide-two-integers

## 解题记录

+ 优先考虑溢出的情况，在MIN_VALUE转化为MAX_VALUE会产生溢出，直接返回即可
+ 然后通过`<<1`的除数`*2`操作，找到 $dividend * 2^n$情况进行加减处理
+ 最后输出结果

```java
/**
 * @author: ffzs
 * @Date: 2021/10/12 上午6:50
 */
public class Solution {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) return Integer.MAX_VALUE;
            if (divisor == 1) return Integer.MIN_VALUE;
        }

        long res = 0;
        long m = Math.abs((long)dividend), n = Math.abs((long)divisor);
        boolean sign = false;
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) sign = true;

        while (m >= n) {
            long d = n, c = 1;
            while (m >= (d << 1)){
                d <<= 1;
                c <<= 1;
            }
            res += c;
            m -= d;
        }
        return sign?(int)res:(int)-res;
    }

}
```

![image-20211012073231031](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211012073231031.png)