## 368. 最大整除子集

## 题目



给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
answer[i] % answer[j] == 0 ，或
answer[j] % answer[i] == 0
如果存在多个有效解子集，返回其中任何一个均可。

 

```java
示例 1：

输入：nums = [1,2,3]
输出：[1,2]
解释：[1,3] 也会被视为正确答案。
示例 2：

输入：nums = [1,2,4,8]
输出：[1,2,4,8]
```



```java
提示：

1 <= nums.length <= 1000
1 <= nums[i] <= 2 * 109
nums 中的所有整数 互不相同
```


链接：https://leetcode-cn.com/problems/largest-divisible-subset

## 解题记录

+ 优先通过动态规划求得最大的子链的大小，然后在倒推回找到所有的子链成员
+ 因为是通过相除余数进行判断，那么`dp[i] = dp[j] + 1, nums[i]%nums[j]=0​`获取最大子链数
+ 最后通过逐级递减maxSize，找到相应的数值，然后通过判断能否被整除获取子链成员

```java
/**
 * @author: ffzs
 * @Date: 2021/4/23 上午9:05
 */
public class Solution {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.sort(nums);
        int maxSize = 0, maxValue = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i]%nums[j] == 0) dp[i] = Math.max(dp[j]+1, dp[i]);
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxValue = nums[i];
            }
        }
        List<Integer> res = new ArrayList<>();
        if (maxSize == 1) {
            res.add(nums[0]);
            return res;
        }

        for (int i = n - 1; i >= 0 && maxSize > 0; i--) {
            if (dp[i] == maxSize && maxValue % nums[i] == 0) {
                maxValue = nums[i];
                res.add(maxValue);
                maxSize--;
            }
        }

        return res;
    }

}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        System.out.println(solution.largestDivisibleSubset(nums));
    }
}
```

![image-20210423100412535](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210423100412535.png)