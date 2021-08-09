## 413. 等差数列划分

## 题目

如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。

例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。

子数组 是数组中的一个连续序列。

```java
示例 1：
输入：nums = [1,2,3,4]
输出：3
解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
    
示例 2：
输入：nums = [1]
输出：0

提示：
1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000
```


链接：https://leetcode-cn.com/problems/arithmetic-slices

## 解题记录

+ 其实就是自数列增加一个值，之前数列所有情况都会增加一种情况，除此之外还会多添加一个

```java
/**
 * @author: ffzs
 * @Date: 2021/8/10 上午6:58
 */
public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int res = 0;
        int diff = nums[0] - nums[1];
        int cnt = 0;

        for (int i = 2; i < n; i++) {
            if (nums[i - 1] - nums[i] == diff) cnt ++;
            else {
                diff = nums[i - 1] - nums[i];
                cnt = 0;
            }
            res += cnt;
        }
        return res;
    }

}
```

![image-20210810072724179](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210810072724179.png)