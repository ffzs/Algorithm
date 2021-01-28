## [724. 寻找数组的中心索引](https://leetcode-cn.com/problems/find-pivot-index/)

## 题目

给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。

我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。

如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。

 

```java
示例 1：

输入：
nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
同时, 3 也是第一个符合要求的中心索引。
示例 2：

输入：
nums = [1, 2, 3]
输出：-1
解释：
数组中不存在满足此条件的中心索引。
```



```java
说明：

nums 的长度范围为 [0, 10000]。
任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
```


链接：https://leetcode-cn.com/problems/find-pivot-index

## 解题记录

+ 直接取和，然后判断遍历左边判断是否为一半
+ 或是左右双指针向中间加和，但是要判断正负数



```java
/**
 * @author: ffzs
 * @Date: 2021/1/28 上午8:16
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        double leftSum = 0;

        for (int num : nums) sum += num;

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == (sum - nums[i]) / 2d) return i;
            leftSum += nums[i];
        }

        return -1;
    }

}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,7,3,6,5,6};
        System.out.println(solution.pivotIndex(nums));
    }
}
```

![image-20210128084616811](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210128084616811.png)