## [485. 最大连续1的个数](https://leetcode-cn.com/problems/max-consecutive-ones/)

## 题目

给定一个二进制数组， 计算其中最大连续1的个数。

示例 1:

输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
注意：

输入的数组只包含 0 和1。
输入数组的长度是正整数，且不超过 10,000。


链接：https://leetcode-cn.com/problems/max-consecutive-ones

## 解题记录

+ 直接遍历计数即可
+ 用双指针可能更快一些

```java
/**
 * @author: ffzs
 * @Date: 2021/2/15 上午8:48
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, res = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
                if (count > res) res = count;
            }
            else {
                count = 0;
            }
        }
        return res;
    }
}
```

![image-20210215085736037](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210215085736037.png)