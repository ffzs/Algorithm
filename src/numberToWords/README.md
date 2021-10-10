## 273. 整数转换英文表示

## 题目

将非负整数 num 转换为其对应的英文表示。

```java
示例 1：

输入：num = 123
输出："One Hundred Twenty Three"
示例 2：

输入：num = 12345
输出："Twelve Thousand Three Hundred Forty Five"
示例 3：

输入：num = 1234567
输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
示例 4：

输入：num = 1234567891
输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
```



```java
提示：

0 <= num <= 231 - 1
```

链接：https://leetcode-cn.com/problems/integer-to-english-words


## 解题记录

+ 经观察可得，数字转化为英语的话，3个一周期，处理是相同，同时需要处理1X和XX的情况不同
+ 做好逻辑判断即可

```java
/**
 * @author: ffzs
 * @Date: 2021/10/11 上午6:55
 */
public class Solution {
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder sb = new StringBuilder();
        for (int i = 3, unit = 1_000_000_000; i >= 0; i--, unit /= 1000) {
            int cur = num / unit;
            if (cur != 0) {
                num -= cur * unit;
                StringBuilder curSb = new StringBuilder();
                num2English(curSb, cur);
                curSb.append(thousands[i]).append(" ");
                sb.append(curSb);
            }
        }
        return sb.toString().trim();
    }

    private void num2English(StringBuilder sb, int num) {
        if (num == 0) return;
        else if (num < 10) sb.append(singles[num]).append(" ");
        else if (num < 20) sb.append(teens[num-10]).append(" ");
        else if (num < 100) {
            sb.append(tens[num/10]).append(" ");
            num2English(sb, num % 10);
        }
        else {
            sb.append(singles[num/100]).append(" Hundred ");
            num2English(sb, num % 100);
        }
    }
}
```

![image-20211011072254573](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211011072254573.png)