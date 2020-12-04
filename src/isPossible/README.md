## [659. 分割数组为连续子序列](https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/)

## 题目

给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。

如果可以完成上述分割，则返回 true ；否则，返回 false 。



```java
示例 1：

输入: [1,2,3,3,4,5]
输出: True
解释:
你可以分割出这样两个连续子序列 : 
1, 2, 3
3, 4, 5

示例 2：输入: [1,2,3,3,4,4,5,5]
输出: True
解释:
你可以分割出这样两个连续子序列 : 
1, 2, 3, 4, 5
3, 4, 5

示例 3：

输入: [1,2,3,4,4,5]
输出: False

```


提示：

输入的数组长度范围为 [1, 10000]


链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences

## 解题记录

+ 整体来说还是比较判断数组连续递增即可，因为有重复的情况需要额外关注
+ 通过统计数组中数值出现的次数方便处理重叠部分
+ 重叠部分通过监控最大值情况，个数小于最大重叠即结束重叠

```java
/**
 * @author: ffzs
 * @Date: 2020/12/4 上午7:38
 */

public class Solution {
    public boolean isPossible(int[] nums) {
        int min = nums[0];
        int[] count = new int[nums[nums.length-1]-min+1];
        for (int i : nums) {
            count[i-min]++;
        }
        int n = nums.length;
        while (n > 0) {
            int re = split(count);
            if (re < 3) return false;
            else n -= re;
        }
        return true;
    }

    private int split(int[] count) {
        int i = 0, ret = 1;
        while (i < count.length && count[i] == 0) i++;
        int max = count[i];
        count[i++]--;
        while ((i < count.length && count[i] >= max)) {
            ret++;
            max = Math.max(count[i], max);
            count[i]--;
            i++;
        }
        return ret;
    }
}

class Test{
    public static void main(String[] args) {
//        int[] nums = {1,2,3,3,4,5};
        int[] nums = {1,2,3,4,6,7,8,9,10,11};
        Solution solution = new Solution();
        System.out.println(solution.isPossible(nums));
    }
}
```

![image-20201204082658805](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201204082658805.png)