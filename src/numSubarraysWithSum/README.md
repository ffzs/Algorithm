## 930. 和相同的二元子数组

## 题目

给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。

子数组 是数组的一段连续部分。

```java
示例 1：

输入：nums = [1,0,1,0,1], goal = 2
输出：4
解释：
如下面黑体所示，有 4 个满足题目要求的子数组：
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
示例 2：

输入：nums = [0,0,0,0,0], goal = 0
输出：15
```

```java
提示：

1 <= nums.length <= 3 * 104
nums[i] 不是 0 就是 1
0 <= goal <= nums.length
```


链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum

## 解题记录

+ 通过滑动窗口统计出不多余goal的情况的个数
+ 这里窗口的大小改变就会新增 `j-i+1`种情况
+ 最后通过不多余goal的情况减去不超过goal-1的情况得到正好等于goal的情况

```java
/**
 * @author: ffzs
 * @Date: 2021/7/8 上午6:54
 */
public class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        return mostK(nums, goal) - mostK(nums, goal-1);
    }

    private int mostK(int[] nums, int k) {
        if (k < 0) return 0;
        int i = 0, ret = 0;

        for (int j = 0; j < nums.length; j++) {
            k -= nums[j];
            while (k < 0){
                k += nums[i++];
            }
            ret += j-i+1;
        }
        return ret;
    }

}
```

![image-20210708072202487](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210708072202487.png)