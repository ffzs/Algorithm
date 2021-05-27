## 461. 汉明距离

## 题目

两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

给出两个整数 x 和 y，计算它们之间的汉明距离。

注意：
0 ≤ x, y < 231.

示例:

```java
输入: x = 1, y = 4

输出: 2

解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

上面的箭头指出了对应二进制位不同的位置。
```


链接：https://leetcode-cn.com/problems/hamming-distance

## 解题记录

+ 直接异或求出各个位置不相同的情况
+ 然后获取每一位为1的情况

```java
/**
 * @author: ffzs
 * @Date: 2021/5/27 上午8:31
 */
public class Solution {

    public int hammingDistance(int x, int y) {
        int z = x ^ y;

        int res = 0;
        while (z > 0) {
            if ((z & 1) == 1) res ++;
            z >>= 1;
        }
        return res;
    }
}
```

![image-20210527084117437](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210527084117437.png)