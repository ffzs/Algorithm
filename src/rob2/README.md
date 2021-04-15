## 213. 打家劫舍 II

## 题目

你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

```java
示例 1：
输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
    
示例 2：
输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
    
示例 3：
输入：nums = [0]
输出：0
```

```java
提示：

1 <= nums.length <= 100
0 <= nums[i] <= 1000
```


链接：https://leetcode-cn.com/problems/house-robber-ii



## 解题记录

+ 因为第一个房屋和最后一个房屋不能同时被偷，那么只要拆解为两种情况，第一种情况有第一间屋子没有最后一间，第二种情况有最后一间屋子，没有第一间
+ 然后分别通过动态规划求得最大金额，取两者的最大值

```java
/**
 * @author: ffzs
 * @Date: 2021/4/15 上午9:18
 */
public class Solution {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] pre = Arrays.copyOf(nums, n - 1);
        int[] suf = Arrays.copyOfRange(nums, 1, n);
        return Math.max(helper(pre), helper(suf));
    }

    private int helper(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dp = new int[len + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= len; ++i) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[len];
    }
}
```

![image-20210415100613571](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210415100613571.png)