## java477. 汉明距离总和

## 题目

两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。

计算一个数组中，任意两个数之间汉明距离的总和。

```java
示例:

输入: 4, 14, 2

输出: 6

解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
所以答案为：
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
```

```java
注意:

数组中元素的范围为从 0到 10^9。
数组的长度不超过 10^4。
```


链接：https://leetcode-cn.com/problems/total-hamming-distance

## 解题记录

+ 汉明距离就是指二进制中某一位的不同情况
+ 因为单独看某一位的话，就单独来看这一位的情况
+ 有 c和 1 和 n-c个 0 的话有多少种 1, 0 组合呢？
+ 每一个0 有 c种1可以匹配，然后又n-c个0 ，那么匹配的种类有c * (n-c)

```java
/**
 * @author: ffzs
 * @Date: 2021/5/28 上午7:31
 */
public class Solution {

    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < 30; i++) {
            int one = 0;
            for (int num : nums) {
                one += (num >> i) & 1;
            }
            res += one * (n - one);
        }
        return res;
    }

}
```

![image-20210528080102660](README.assets/image-20210528080102660.png)