## [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

## 题目

给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

```
示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

示例 2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

示例 3：
输入：nums = [], target = 0
输出：[-1,-1]
```


提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums 是一个非递减数组
-109 <= target <= 109


链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array

## 解题记录

+ 二分法找到target位置
+ 然后通过target位置找到该值的左端和右端

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/6/7
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int left = 0, right = nums.length - 1;
        int mid;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] == target) return findSame(nums, mid);
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid - 1; }
        }

        return res;
    }

    private int[] findSame(int[] nums, int mid){
        int left = mid-1, right=mid+1;
        while (left>=0 && nums[left]==nums[mid]) left--;
        while (right<nums.length && nums[right]==nums[mid]) right++;
        return new int[]{left+1, right-1};
    }
}
```

![image-20201201073937254](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201201073937254.png)