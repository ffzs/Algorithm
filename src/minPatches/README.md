## [330. 按要求补齐数组](https://leetcode-cn.com/problems/patching-array/)

## 题目

给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。

```java
示例 1:
输入: nums = [1,3], n = 6
输出: 1 
解释:
根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
所以我们最少需要添加一个数字。
    
示例 2:
输入: nums = [1,5,10], n = 20
输出: 2
解释: 我们需要添加 [2, 4]。
    
示例 3:
输入: nums = [1,2,2], n = 5
输出: 0
```


链接：https://leetcode-cn.com/problems/patching-array

## 解题记录

+ 通过贪婪算法求解
+ 因为`[1, total]`范围内的数值可以之和可以覆盖`[1, total*2-1]`的范围
+ 如果出现n以内有大于` total*2-1`的数值那么，添加一个数total*2，直到达到n

```java
/**
 * @author: ffzs
 * @Date: 2020/12/29 下午7:30
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        long total = 1;
        int res = 0, i = 0;
        while (total <= n) {
            if (i < nums.length && nums[i] <= total) {
                total += nums[i++];
            }else {
                total *= 2;
                res ++;
            }
        }
        return res;
    }
}
```

![image-20201229202335917](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201229202335917.png)