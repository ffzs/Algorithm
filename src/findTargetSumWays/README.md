## 494. 目标和

## 题目

给你一个整数数组 nums 和一个整数 target 。

向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

```java
示例 1：

输入：nums = [1,1,1,1,1], target = 3
输出：5
解释：一共有 5 种方法让最终目标和为 3 。
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
示例 2：

输入：nums = [1], target = 1
输出：1
```

```java
提示：

1 <= nums.length <= 20
0 <= nums[i] <= 1000
0 <= sum(nums[i]) <= 1000
-1000 <= target <= 100
```


链接：https://leetcode-cn.com/problems/target-sum

## 解题记录

+ 回溯算法，对于每一个nums成员有两种选择加或减，这里遍历所有情况即可

```java
/**
 * @author: ffzs
 * @Date: 2021/6/7 上午6:58
 */
public class Solution {

    int[] nums;
    int target, res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        dfs(0, 0);
        return res;
    }

    private void dfs(int index, int sum){
        if (nums.length == index) {
            if (sum == target) res++;
            return;
        }

        dfs(index + 1, sum + nums[index]);
        dfs(index + 1, sum - nums[index]);
    }
}
```

![image-20210607072606543](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210607072606543.png)

+ 动态规划
+ 这里nums有两种情况，一种是加和一种是减去，$（sum-neg）-neg = target$, 由此可知， 由于sum-target必定为整数， 那么 neg一定是偶数
+ 这里我们使用背包，第二纬度通过neg大小作为限制

```java
/**
 * @author: ffzs
 * @Date: 2021/6/7 上午7:04
 */
public class Solution2 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < target || (sum + target) % 2 == 1) return 0;

        int bg = (sum-target)/2;
        int[] dp = new int[bg+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = bg; i >= num; i--) {
                dp[i] = dp[i] + dp[i-num];
            }
        }
        return dp[bg];
    }

}
```

![image-20210607073154511](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210607073154511.png)