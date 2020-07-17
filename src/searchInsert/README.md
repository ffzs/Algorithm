## [35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/)

## 题目

给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。

```java
示例 1:

输入: [1,3,5,6], 5
输出: 2
```

```java
示例 2:

输入: [1,3,5,6], 2
输出: 1
```

```java
示例 3:

输入: [1,3,5,6], 7
输出: 4
```

```java
示例 4:

输入: [1,3,5,6], 0
输出: 0

```


链接：https://leetcode-cn.com/problems/search-insert-position

## 解题记录

+ 便利数组，如果`nums[i]`的大小大于等于target，返回index
+ 如果数组中数值都小于target的话，返回最后index+1，也就是length

```java
public class Solution {
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }
}

```

![image-20200717075755640](README.assets/image-20200717075755640.png)

+ 通过二分法获取target位置

```java
public class Solution2 {
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        if (target > nums[r]) return r+1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));
    }
}

```

![image-20200717081125978](README.assets/image-20200717081125978.png)