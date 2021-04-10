## 263. 丑数

给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。

丑数 就是只包含质因数 2、3 和/或 5 的正整数。

```java
示例 1：

输入：n = 6
输出：true
解释：6 = 2 × 3
示例 2：

输入：n = 8
输出：true
解释：8 = 2 × 2 × 2
示例 3：

输入：n = 14
输出：false
解释：14 不是丑数，因为它包含了另外一个质因数 7 。
示例 4：

输入：n = 1
输出：true
解释：1 通常被视为丑数。
```

```java
提示：

-231 <= n <= 231 - 1
```


链接：https://leetcode-cn.com/problems/ugly-number

## 解题记录

+ 直接通过递归求解，能够被2,3,5整除的数求商再进入下一个循环，因为1也被认为是丑数，那么跳出条件也加上1
+ 因为丑数是正整数，0肯定也不是，那么小于等于0的直接false

```java
/**
 * @author: ffzs
 * @Date: 2021/4/10 上午8:08
 */
public class Solution {

    public boolean isUgly(int n) {
        if (n == 1 || n == 2 || n == 3 || n == 5) return true;
        else if (n <= 0) return false;

        if (n%2 == 0) return isUgly(n/2);
        else if (n%3 == 0) return isUgly(n/3);
        else if (n%5 == 0) return isUgly(n/5);
        else return false;
    }

}
```

![image-20210410081954484](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210410081954484.png)