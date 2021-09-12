## 678. 有效的括号字符串

## 题目

给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：

任何左括号 ( 必须有相应的右括号 )。
任何右括号 ) 必须有相应的左括号 ( 。
左括号 ( 必须在对应的右括号之前 )。
* 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
  一个空字符串也被视为有效字符串。

  ```java
  * 示例 1:
  
  输入: "()"
  输出: True
  示例 2:
  
  输入: "(*)"
  输出: True
  示例 3:
  
  输入: "(*))"
  输出: True
  注意:
  
  字符串大小将在 [1，100] 范围内。
  ```

  


链接：https://leetcode-cn.com/problems/valid-parenthesis-string

## 解题记录

+ 通过栈记录括号和星号
+ 星号可以任意匹配，因此需要优先匹配括号
+ 最后检查左扣号和星号的匹配关系即可



```java
/**
 * @author: ffzs
 * @Date: 2021/9/12 上午7:36
 */

public class Solution {

    public boolean checkValidString(String s) {
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> star = new LinkedList<>();

        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') left.push(i);
            else if (cs[i] == '*') star.push(i);
            else if (left.isEmpty() && star.isEmpty()) return false;
            else {
                if (!left.isEmpty()) {
                    left.pop();
                }
                else star.pop();
            }
        }


        while (!left.isEmpty() && !star.isEmpty()) {
            int leftIndex = left.pop();
            int starIndex = star.pop();
            if (leftIndex > starIndex) {
                return false;
            }
        }
        return left.isEmpty();
    }

    public boolean checkValidString2(String s) {
        int min = 0, max = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                min = Math.max(min - 1, 0);
                max--;
                if (max < 0) return false;
            } else {
                min = Math.max(min - 1, 0);
                max++;
            }
        }
        return min == 0;
    }
}
```

![image-20210912081136222](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210912081136222.png)