## 13. 罗马数字转整数

## 题目

罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。

```
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
```


例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

 

```java
示例 1:
输入: "III"
输出: 3
    
示例 2:
输入: "IV"
输出: 4
    
示例 3:
输入: "IX"
输出: 9
    
示例 4:
输入: "LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.
    
示例 5:
输入: "MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.
```

```java
提示：

1 <= s.length <= 15
s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
```


链接：https://leetcode-cn.com/problems/roman-to-integer

## 解题记录

+ 通过罗马字符和数值的映射关系转化累加
+ 需要特别注意的是当字符为'IX'这类需要特殊注意，需要两个组合进行转化



```java
/**
 * @author: ffzs
 * @Date: 2021/5/15 上午8:36
 */
public class Solution2 {

    public int romanToInt(String s) {
        char[] cs = s.toCharArray();

        int i = 0, res = 0;
        while (i < cs.length) {
            switch (cs[i]) {
                case 'C':
                    if (i + 1 == cs.length || (i + 1 < cs.length && cs[i + 1] != 'M' && cs[i + 1] != 'D')) res += 100;
                    else {
                        if (cs[i + 1] == 'M') res += 900;
                        else res += 400;
                        i++;
                    }
                    break;
                case 'X':
                    if (i + 1 == cs.length || (i + 1 < cs.length && cs[i + 1] != 'C' && cs[i + 1] != 'L')) res += 10;
                    else {
                        if (cs[i + 1] == 'C') res += 90;
                        else res += 40;
                        i++;
                    }
                    break;
                case 'I':
                    if (i + 1 == cs.length || (i + 1 < cs.length && cs[i + 1] != 'X' && cs[i + 1] != 'V')) res += 1;
                    else {
                        if (cs[i + 1] == 'X') res += 9;
                        else res += 4;
                        i++;
                    }
                    break;
                case 'M':
                    res += 1000;
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'V':
                    res += 5;
                    break;
            }
            i++;
        }

        return res;
    }

}
```

![image-20210515090005253](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210515090005253.png)