## 1137. 第 N 个泰波那契数

## 题目

泰波那契序列 Tn 定义如下： 

T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2

给你整数 n，请返回第 n 个泰波那契数 Tn 的值。

```java
示例 1：

输入：n = 4
输出：4
解释：
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
示例 2：

输入：n = 25
输出：1389537
```

```java
提示：

0 <= n <= 37
答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
```

链接：https://leetcode-cn.com/problems/n-th-tribonacci-number



## 解题记录

+ 按照要求进行状态转移即可

```java
/**
 * @author: ffzs
 * @Date: 2021/8/8 下午1:18
 */
public class Solution {

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1|| n == 2) return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int t = a;
            a = b;
            b = c;
            c = a + b + t;
        }
        return c;
    }

}
```

![image-20210808133219218](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210808133219218.png)