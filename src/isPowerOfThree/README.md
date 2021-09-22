## 326. 3的幂

## 题目

给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。

整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x

 

示例 1：

输入：n = 27
输出：true
示例 2：

输入：n = 0
输出：false
示例 3：

输入：n = 9
输出：true
示例 4：

输入：n = 45
输出：false


提示：

-231 <= n <= 231 - 1

```java
进阶：

你能不使用循环或者递归来完成本题吗？
```


链接：https://leetcode-cn.com/problems/power-of-three

## 解题记录

+ 通过3的最大指数除以该数，如果能整除说明是3的倍数

```java
/**
 * @author: ffzs
 * @Date: 2021/9/23 上午6:50
 */
public class Solution {

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

}
```

![image-20210923070140741](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210923070140741.png)