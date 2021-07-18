## 1838. 最高频元素的频数

## 题目

元素的 频数 是该元素在一个数组中出现的次数。

给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。

执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。

```java
示例 1：
输入：nums = [1,2,4], k = 5
输出：3
解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
4 是数组中最高频元素，频数是 3 。
    
示例 2：
输入：nums = [1,4,8,13], k = 5
输出：2
解释：存在多种最优解决方案：
- 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
- 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
- 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
    
  示例 3：
输入：nums = [3,9,6], k = 2
输出：1
```

```java
提示：

1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= k <= 105
```


链接：https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element


## 解题记录

+ 通过互动窗口维护一个窗口内部补全到r的总和值
+ 然后获取最大的该值即为最大频率

```java
/**
 * @author: ffzs
 * @Date: 2021/7/19 上午6:53
 */
public class Solution {

    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int l = 0;
        int res = 1;
        long sum = 0L;
        for (int r = 1; r < n; r++) {
            sum += (nums[r] - nums[r - 1]) * (r - l);
            while (sum > k) {
                sum -= nums[r] - nums[l++];
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

}
```

![image-20210719071209728](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210719071209728.png)