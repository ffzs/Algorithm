## [343. 整数拆分](https://leetcode-cn.com/problems/integer-break/) 

## 题目

给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

```java
示例 1:

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
```

```java
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
说明: 你可以假设 n 不小于 2 且不大于 58。
```


链接：https://leetcode-cn.com/problems/integer-break

## 解题记录

+ 根据题意可知 2->1, 3->2, 4->4, 5->6
+ 这前几个数，其中到4拆解之后跟原来一样，而5拆解成2*3得到的6比5大
+ 因此可以这样想，当你拆数的时候比如10, 拆成5+5,又可知5其实拆成6会有提升，就是找到拆到什么时候这个数的乘积不在又提升
+ 上面可以看出直到2和3,不再有提升，可以不用再继续拆
+ 再者6这个数可以拆成2+2+2 -> 8, 3+3 -> 9 得出尽量拆成3为主
+ 因此有

```java
/**
 * @author: ffzs
 * @Date: 2020/7/30 上午9:14
 */
public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int n3 = n/3;
        int remainder = n % 3;
        if (remainder == 0) return (int) Math.pow(3, n3);
        else if (remainder == 1) return (int) Math.pow(3, n3 - 1) * 4;
        else return (int) Math.pow(3, n3) * 2;
    }
}
```

![image-20200730094726025](README.assets/image-20200730094726025.png)

