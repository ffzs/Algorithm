## 581. 最短无序连续子数组

## 题目

给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

请你找出符合题意的 最短 子数组，并输出它的长度。

 

```java
示例 1：

输入：nums = [2,6,4,8,10,9,15]
输出：5
解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
示例 2：

输入：nums = [1,2,3,4]
输出：0
示例 3：

输入：nums = [1]
输出：0
```



```java
提示：

1 <= nums.length <= 104
-105 <= nums[i] <= 105


进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
```


链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray

## 解题记录

+ 简单思考就是优先通过排序将数组处理成有序状态
+ 然后从头尾去掉重复的部分，剩下的就是需要重新排序的部分
+ 也可以通过维护一个最大最小值，这样的话就不用进行排序了

```java
/**
 * @author: ffzs
 * @Date: 2021/8/3 上午6:54
 */
public class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int[] tmp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(tmp);
        int i = 0, j = nums.length - 1;
        while (i < nums.length && tmp[i] == nums[i]) i++;
        while (j > i && tmp[j] == nums[j]) j--;
        return j - i + 1;
    }


    public int findUnsortedSubarray2(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[n - 1];
        int begin = 0, end = -1;

        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < max) end = i;
            else max = nums[i];
            if (nums[j] > min) begin = j;
            else min = nums[j];
        }
        return end - begin + 1;
    }

}
```

![image-20210803071357891](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210803071357891.png)