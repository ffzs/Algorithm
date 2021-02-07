## [665. 非递减数列](https://leetcode-cn.com/problems/non-decreasing-array/)

## 题目

给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

 

```java
示例 1:

输入: nums = [4,2,3]
输出: true
解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
示例 2:

输入: nums = [4,2,1]
输出: false
解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
```

```java
说明：

1 <= n <= 10 ^ 4
- 10 ^ 5 <= nums[i] <= 10 ^ 5
```


链接：https://leetcode-cn.com/problems/non-decreasing-array


## 解题记录

+ 通过检查有递减趋势的地方，可以有跳过一回的机会
+ 这里需要注意的事跳过的地方保留哪个需要跟前面的比较
+ 这种需要跳过的点，后面的比前面的小，为了贪心尽可能保留小的，有一点注意小的不能不能比再前面那个点小不然就不符合规则

```java
/**
 * @author: ffzs
 * @Date: 2021/2/7 上午8:22
 */
public class Solution {

    public boolean checkPossibility(int[] nums) {
        int count = 1;
        int preIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[preIndex]) {
                if (preIndex == 0 || nums[i] >= nums[preIndex - 1]) preIndex = i;
                count --;
            }
            else preIndex = i;
            if (count < 0) return false;
        }
        return true;
    }

}
```

![image-20210207090201126](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210207090201126.png)