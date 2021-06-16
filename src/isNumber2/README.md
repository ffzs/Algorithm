## 65. 有效数字

## 题目

有效数字（按顺序）可以分成以下几个部分：

一个 小数 或者 整数
（可选）一个 'e' 或 'E' ，后面跟着一个 整数
小数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
下述格式之一：
至少一位数字，后面跟着一个点 '.'
至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
一个点 '.' ，后面跟着至少一位数字
整数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
至少一位数字
部分有效数字列举如下：

["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
部分无效数字列举如下：

["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。

 

```java
示例 1：

输入：s = "0"
输出：true
示例 2：

输入：s = "e"
输出：false
示例 3：

输入：s = "."
输出：false
示例 4：

输入：s = ".1"
输出：true
```



```java
提示：

1 <= s.length <= 20
s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。
```


链接：https://leetcode-cn.com/problems/valid-number

## 解题记录

之前做过类似的写一下规律：

+ 第一个字符可以是`+`，`-`,数字
+ `e`或`E`前必有数字，`e`后只能是整数
+ `e`只能出现一次

```java
/**
 * @author: ffzs
 * @Date: 2021/6/17 上午6:57
 */
public class Solution {

    boolean haveE =  false;
    boolean isFloat = false;
    boolean haveSymbol = false;
    boolean haveNumber = false;
    public boolean isNumber(String s) {
        char[] seq = s.toCharArray();
        int i = 0;

        while (i < seq.length) {
            // System.out.println(seq[i]);
            switch (seq[i]) {
                // 之前不能有数组和小数点
                case '-':
                case '+':
                    if (haveNumber||isFloat) return false;
                    haveSymbol = true;
                    i++; break;
                // e之后的不能出现小数，已经有小数点的不能再出现小数点
                case '.':
                    if (haveE||isFloat) return false;
                    isFloat = true;
                    i++; break;
                // 之前没有数字不行 刷新之前number和小数
                case 'e':
                case 'E':
                    if(haveE||!haveNumber) return false;
                    haveNumber=false;
                    isFloat=false;
                    haveE=true;
                    return isNumber(s.substring(i+1));
                default:
                    // 剩下的如果不是数字不行
                    if(isNum(seq[i])){
                        haveNumber = true;
                        i++; break;
                    }
                    else return false;
            }
        }
        // 整个字符必须有数字才能算数
        return haveNumber;
    }

    private boolean isNum (char c) {
        return c>='0' && c<='9';
    }

}
```

![image-20210617071259835](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210617071259835.png)