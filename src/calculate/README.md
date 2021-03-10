## [224. 基本计算器](https://leetcode-cn.com/problems/basic-calculator/)

## 题目

实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。

```java
示例 1：

输入：s = "1 + 1"
输出：2
示例 2：

输入：s = " 2-1 + 2 "
输出：3
示例 3：

输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23
```

```java
提示：

1 <= s.length <= 3 * 105
s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
s 表示一个有效的表达式
```


链接：https://leetcode-cn.com/problems/basic-calculator

## 解题记录

+ 通过栈处理括号问题，遇到前括号的话将括号内数据的符号添加到栈中，每次遇到后括号，将该符号弹出
+ 由于只有加减计算因此只要通过调整符号累加即可

```java
/**
 * @author: ffzs
 * @Date: 2021/3/10 上午7:49
 */
public class Solution {

    public int calculate(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        Deque<Integer> deque = new LinkedList<>();

        int sign = 1;
        deque.push(sign);

        int i = 0, res = 0;
        while (i < n) {
            if (cs[i] == ' ') ;
            else if (cs[i] == '+') sign = deque.peek();
            else if (cs[i] == '-') sign = -deque.peek();
            else if (cs[i] == '(') deque.push(sign);
            else if (cs[i] == ')') deque.pop();
            else {
                long num = 0;
                while (i < n && cs[i] >= '0' && cs[i] <= '9') {
                    num = num*10 + cs[i] - '0';
                    i ++;
                }
                res += sign*num;
                i --;
            }
            i ++;
        }
        return res;
    }

}
```

![image-20210310183530731](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210310183530731.png)