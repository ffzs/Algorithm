## [1365. 有多少小于当前数字的数字](https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/)

## 题目

给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。

换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。

以数组形式返回答案。

```java
示例 1：

输入：nums = [8,1,2,2,3]
输出：[4,0,1,1,3]
解释： 
对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。 
对于 nums[1]=1 不存在比它小的数字。
对于 nums[2]=2 存在一个比它小的数字：（1）。 
对于 nums[3]=2 存在一个比它小的数字：（1）。 
对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
```

```java
示例 2：

输入：nums = [6,5,4,8]
输出：[2,1,0,3]
```

```java
示例 3：

输入：nums = [7,7,7,7]
输出：[0,0,0,0]
```


提示：

2 <= nums.length <= 500
0 <= nums[i] <= 100


链接：https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number

## 解题记录

+ 由于`**0 <= nums[i] <= 100**`首先统计出每个数出现的次数
+ 通过前缀和的方式统计出数量累和情况
+ 然后再根据数值返回对应小于个数，0没有

```java
/**
 * @author: ffzs
 * @Date: 2020/10/26 上午6:16
 */

public class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] counter = new int[101];
        for (int num : nums) counter[num]++;
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i-1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0) res[i] = counter[nums[i]-1];
        }
        return res;
    }

}
```

![image-20201026063341288](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201026063341288.png)