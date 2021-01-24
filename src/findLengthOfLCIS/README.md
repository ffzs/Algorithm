## [674. 最长连续递增序列](https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/)

## 题目

给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。

连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。

```java
示例 1：

输入：nums = [1,3,5,4,7]
输出：3
解释：最长连续递增序列是 [1,3,5], 长度为3。
尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。 
示例 2：

输入：nums = [2,2,2,2,2]
输出：1
解释：最长连续递增序列是 [2], 长度为1。
```

```java
提示：

0 <= nums.length <= 104
-109 <= nums[i] <= 109
```


链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence

## 解题记录

+ 直接判断即可没啥好说的

```java
/**
 * @author: ffzs
 * @Date: 2021/1/24 上午8:08
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 0, counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                counter ++;
            }
            else {
                res = Math.max(res, counter);
                counter = 1;
            }
        }

        return Math.max(res, counter);
    }

}
```

![image-20210124081951778](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210124081951778.png)