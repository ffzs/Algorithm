## 12. 整数转罗马数字

## 题目

罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

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
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。



```java
示例 1:

输入: 3
输出: "III"
示例 2:

输入: 4
输出: "IV"
示例 3:

输入: 9
输出: "IX"
示例 4:

输入: 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.
示例 5:

输入: 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.
```



```java
提示：

1 <= num <= 3999
```


链接：https://leetcode-cn.com/problems/integer-to-roman


## 解题记录

+ 本题是一个数值转换题目，通过对用关系相除，将商换位对应的罗马字符
+ 这里有个难点就是4，9的表示，要求特殊处理一下逻辑通过判断是否符合，如96 + 10 > 100，说明需要特殊处理

```java
/**
 * @author: ffzs
 * @Date: 2021/5/14 上午7:49
 */
public class Solution {

    public String intToRoman(int num) {
        int[] v = {1000, 500, 100, 50, 10, 5, 1};
        int[] gap = {100, 100, 10, 10, 1, 1, 0};
        char[] c = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        char[] gc = {'C', 'C', 'X', 'X', 'I', 'I', 'I'};

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num != 0) {
            if (num / v[i] != 0) {
                sb.append(c[i]);
                num -= v[i];
            }
            else if (num % v[i] + gap[i] >= v[i]){
                sb.append(gc[i]);
                num += gap[i];
            }
            else{
                i++;
            }
        }
        return sb.toString();
    }

}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.intToRoman(1994));
    }
}
```

![image-20210514082049184](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210514082049184.png)