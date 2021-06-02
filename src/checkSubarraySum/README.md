## 523. 连续的子数组和

## 题目

给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：

子数组大小 至少为 2 ，且
子数组元素总和为 k 的倍数。
如果存在，返回 true ；否则，返回 false 。

如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。

```java
示例 1：

输入：nums = [23,2,4,6,7], k = 6
输出：true
解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
示例 2：

输入：nums = [23,2,6,4,7], k = 6
输出：true
解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。 
42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
示例 3：

输入：nums = [23,2,6,4,7], k = 13
输出：false
```

```java
提示：

1 <= nums.length <= 105
0 <= nums[i] <= 109
0 <= sum(nums[i]) <= 231 - 1
1 <= k <= 231 - 1
```


链接：https://leetcode-cn.com/problems/continuous-subarray-sum

## 解题记录

+ 通过前缀和计算，然后获取每一个区间值然后看是否为k的倍数



```java
/**
 * @author: ffzs
 * @Date: 2021/6/2 上午7:32
 */
public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] tmp = new int[n + 1];
        for (int i = 1; i <= nums.length; i++) {
            tmp[i] = tmp[i - 1] + nums[i];
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i + 2; j < n+1; j++) {
                if ((tmp[j] - tmp[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
```

![image-20210602075820600](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210602075820600.png)

超时了



+ 在处理前缀和的时候我们可以发现，sum[j] - sum[i] 的差能被k整除，那么如果sum[i]除以k的余数和sum[j]除以k的余数相同，那么相减过程中减掉了相同的余数，那么一定是倍数，我们可以讲余数情况放到一个hash中



```java
/**
 * @author: ffzs
 * @Date: 2021/6/2 上午8:01
 */
public class Solution2 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        int remainder = 0;
        Map<Integer, Integer> map = new HashMap<>(){{
            put(0,-1);
        }};

        for (int i = 0; i < n; i++) {
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) return true;
            }
            else map.put(remainder, i);
        }

        return false;
    }

}
```

![image-20210602080633185](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210602080633185.png)