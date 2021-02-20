## [697. 数组的度](https://leetcode-cn.com/problems/degree-of-an-array/)

## 题目

给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

```java
示例 1：

输入：[1, 2, 2, 3, 1]
输出：2
解释：
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
示例 2：

输入：[1,2,2,3,1,4,2]
输出：6
```

```java
提示：

nums.length 在1到 50,000 区间范围内。
nums[i] 是一个在 0 到 49,999 范围内的整数。
```

链接：https://leetcode-cn.com/problems/degree-of-an-array

## 解题记录

+ 有题目可知找到最小长度首先要找到最高频率的那些数值
+ 然后在获取这些最高频率的值得最小窗口
+ 可以以便统计以便确定每个值得最左端和最右端的值
+ 最终直接相减

```java
/**
 * @author: ffzs
 * @Date: 2021/2/20 上午8:31
 */
public class Solution2 {


    public int findShortestSubArray(int[] nums) {

        int[] tmp = new int[50000];
        int[] left = new int[50000];
        int[] right = new int[50000];
        for (int i = 0; i < left.length; i++) {
            left[i] = -1;
            right[i] = -1;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (left[cur] == -1) left[cur] = i;
            right[cur] = i;
            tmp[cur] ++;
            max = Math.max(max, tmp[cur]);
        }
        int res = nums.length;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == max) {
                res = Math.min(res, right[i] - left[i] + 1);
            }
        }
        return res;
    }
}
```

![image-20210220194736595](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210220194736595.png)