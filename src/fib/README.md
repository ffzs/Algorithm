## [509. 斐波那契数](https://leetcode-cn.com/problems/fibonacci-number/)

## 题目

斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

F(0) = 0，F(1) = 1
F(n) = F(n - 1) + F(n - 2)，其中 n > 1
给你 n ，请计算 F(n) 。

```java
示例 1：
输入：2
输出：1
解释：F(2) = F(1) + F(0) = 1 + 0 = 1

示例 2：
输入：3
输出：2
解释：F(3) = F(2) + F(1) = 1 + 1 = 2

示例 3：
输入：4
输出：3
解释：F(4) = F(3) + F(2) = 2 + 1 = 3
```



```java
提示：
0 <= n <= 30
```

链接：https://leetcode-cn.com/problems/fibonacci-number


## 解题记录

+ 递归方法

```java
/**
 * @author: ffzs
 * @Date: 2021/1/4 上午8:42
 */
public class Solution {
    public int fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }
}
```

![image-20210104085243866](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210104085243866.png)

+ 迭代法

```java
/**
 * @author: ffzs
 * @Date: 2021/1/4 上午8:53
 */
public class Solution2 {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i < res.length; i++) {
            res[i] = res[i-1] + res[i-2];
        }
        return res[n];
    }
}
```

![image-20210104085538104](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210104085538104.png)