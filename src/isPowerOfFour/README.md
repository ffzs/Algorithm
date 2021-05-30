## 342. 4的幂

## 题目

给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。

整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x 

```java
示例 1：

输入：n = 16
输出：true
示例 2：

输入：n = 5
输出：false
示例 3：

输入：n = 1
输出：true


提示：

-231 <= n <= 231 - 1


进阶：

你能不使用循环或者递归来完成本题吗？
```


链接：https://leetcode-cn.com/problems/power-of-four

## 解题记录

+ 和 2 的幂相比，这个需要将0统计一下，要是偶数个的话为True

```java
/**
 * @author: ffzs
 * @Date: 2021/5/31 上午7:44
 */
public class Solution {

    public boolean isPowerOfFour(int n) {
        int cnt = 0;

        while (n > 1) {
            if ((n & 1) == 1) return false;
            cnt++;
            n >>= 1;
        }

        return n == 1 && cnt % 2==0;
    }

}
```

![image-20210531075156580](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210531075156580.png)