## [628. 三个数的最大乘积](https://leetcode-cn.com/problems/maximum-product-of-three-numbers/)

## 题目

给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

示例 1:

输入: [1,2,3]
输出: 6
示例 2:

输入: [1,2,3,4]
输出: 24
注意:

给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。


链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers

## 解题记录

+ 排序之后，或是前两个负数相乘再乘以最大值
+ 或是前三大相乘
+ 两者取最大的情况

```java
/**
 * @author: ffzs
 * @Date: 2021/1/20 上午8:28
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = 1;
        for (int i = 1; i < 4; i++) {
            res *= nums[n-i];
        }
        return Math.max(res, nums[0]*nums[1]*nums[n-1]);
    }
}
```

![image-20210120083634432](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210120083634432.png)

