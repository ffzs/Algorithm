## [43. 字符串相乘](https://leetcode-cn.com/problems/multiply-strings/)

## 题目

给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

```java
示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
```



```java
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
```



```java
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
```



链接：https://leetcode-cn.com/problems/multiply-strings



## 解题记录

+ 有这样一个规律：`100*100=10000`,长度5, `99*99`的长度必然为4,因此一个长度为len1和一个长度为len2的两个数相乘，其长度只能是len1+len2或len1+len2-1；
+ 我们通过一个长度len1+len2的数组对得到的每一位数值进行存储
+ 将乘法分解之后，就是一个数乘以第二个数的每一位，之后相加的过程
+ 这一要注意进位问题

```java
/**
 * @author: ffzs
 * @Date: 2020/8/13 上午7:46
 */
public class Solution {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num2.length();
        int n = num1.length();
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int[] tmp = new int[m+n];

        for (int i = 0; i < m; ++i) {
            int v2 = char2[m-1-i] - '0';
            int carry1 = 0;
            int carry2 = 0;
            for (int j = 0; j < n; ++j) {
                int v1 = char1[n-1-j] - '0';
                int product = v1 * v2 + carry2;
                int remainder = product % 10;
                carry2 = product / 10;
                int sum = remainder + tmp[i+j] + carry1;
                carry1 = sum/10;
                tmp[i+j] = sum % 10;
            }
            if (carry2 != 0 || carry1 != 0) {
                int sum = tmp[i+n] + carry2 + carry1;
                tmp[i+n] = sum % 10;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; i--) {
            if (i == tmp.length - 1 && tmp[i] == 0) continue;
            res.append(tmp[i]);
        }

        return res.toString();
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String num1 = "999";
        String num2 = "999";
        System.out.println(solution.multiply(num1, num2));
    }
}
```

![image-20200813083745817](README.assets/image-20200813083745817.png)

+ 其实想了一下进位相加，加和之后在进位其实是一样的，没必要每轮加和都要进位，只要最后统计的时候完成进位即可, 这样可以减少很多计算

```java
/**
 * @author: ffzs
 * @Date: 2020/8/13 上午8:41
 */
public class Solution2 {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num2.length();
        int n = num1.length();
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int[] tmp = new int[m+n];

        for (int i = 0; i < m; ++i) {
            int v2 = char2[m-1-i] - '0';
            for (int j = 0; j < n; ++j) {
                int v1 = char1[n-1-j] - '0';
                tmp[i+j] += v1*v2;
            }
        }

        int carry = 0;
        for (int i = 0; i < tmp.length; ++i) {
            int sum = tmp[i] + carry;
            carry = sum / 10;
            tmp[i] = sum % 10;
        }


        StringBuilder res = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; i--) {
            if (i == tmp.length - 1 && tmp[i] == 0) continue;
            res.append(tmp[i]);
        }

        return res.toString();
    }
}
```



![image-20200813085411170](README.assets/image-20200813085411170.png)