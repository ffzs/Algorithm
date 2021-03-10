## [227. 基本计算器 II](https://leetcode-cn.com/problems/basic-calculator-ii/)

## 题目

给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

整数除法仅保留整数部分。 

```java
示例 1：

输入：s = "3+2*2"
输出：7
示例 2：

输入：s = " 3/2 "
输出：1
示例 3：

输入：s = " 3+5 / 2 "
输出：5
```



```java
提示：

1 <= s.length <= 3 * 105
s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
s 表示一个 有效表达式
表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
题目数据保证答案是一个 32-bit 整数
```


链接：https://leetcode-cn.com/problems/basic-calculator-ii

## 解题记录

+ 获取数值，通过栈存储
+ 遇到加法乘法直接计算
+ 遇到减法将数组取负数
+ 最后将栈中的数值都加和

```java
/**
 * @author: ffzs
 * @Date: 2021/3/11 上午7:08
 */
public class Solution {

    public int calculate(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        Deque<Integer> deque = new LinkedList<>();
        int res = 0;
        char sign = '+';
        int i = 0, num = 0;
        while (i < n) {
            if (cs[i] == ' ');
            else if (cs[i] >= '0' && cs[i] <= '9') {
                num = 0;
                while (i < n && cs[i] <= '9' && cs[i] >= '0') {
                    num = num*10 + cs[i] - '0';
                    i++;
                }
                i--;
                if (sign == '+') deque.push(num);
                else if (sign == '-') deque.push(-num);
                else if (sign == '*') deque.push(deque.pop() * num);
                else if (sign == '/') deque.push(deque.pop() / num);
            }
            else {
                sign = cs[i];
            }
            i++;
        }
        while (!deque.isEmpty()) {
            res += deque.pop();
        }
        return res;
    }

}
```

![image-20210311073330429](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210311073330429.png)