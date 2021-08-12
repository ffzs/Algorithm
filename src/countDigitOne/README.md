## 233. 数字 1 的个数

## 题目

给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。

 

```java
示例 1：

输入：n = 13
输出：6
示例 2：

输入：n = 0
输出：0
```



```java
提示：

0 <= n <= 2 * 109
```


链接：https://leetcode-cn.com/problems/number-of-digit-one

## 解题记录

+ 总结规律
+ 每一位数上出现1的个数是固定的，每次进位正价的也是固定的，注意每回进位之后的1，即可

```java
/**
 * @author: ffzs
 * @Date: 2021/8/13 上午7:01
 */
public class Solution {

    public int countDigitOne(int n) {
        long m = 1;
        int res = 0;
        while (n >= m) {
            res += (n / (m * 10)) * m + Math.min(Math.max(n % (m * 10) - m + 1, 0), m);
            m *= 10;
        }
        return res;
    }

}
```

![image-20210813071417801](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210813071417801.png)