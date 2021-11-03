## 367. 有效的完全平方数

## 题目

给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。

进阶：不要 使用任何内置的库函数，如  sqrt 。

```java
示例 1：

输入：num = 16
输出：true
示例 2：

输入：num = 14
输出：false
```

```java
提示：

1 <= num <= 2^31 - 1
```


链接：https://leetcode-cn.com/problems/valid-perfect-square

## 解题记录

+ 通过二分查找定位平方数的位置

```java
/**
 * @author: ffzs
 * @Date: 2021/11/4 上午7:15
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num <= 1) return true;
        int l = 0, r = num/2;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            long cur = (long)mid * mid;
            if (cur == num) return true;
            else if (cur < num) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }

}
```

![image-20211104075452190](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211104075452190.png)