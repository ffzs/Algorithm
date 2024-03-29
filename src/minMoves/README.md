## 453. 最小操作次数使数组元素相等

## 题目

给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。

```java
示例 1：

输入：nums = [1,2,3]
输出：3
解释：
只需要3次操作（注意每次操作会增加两个元素的值）：
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
示例 2：

输入：nums = [1,1,1]
输出：0
```

```java
提示：

n == nums.length
1 <= nums.length <= 105
-109 <= nums[i] <= 109
答案保证符合 32-bit 整数
```

链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements

## 解题记录

+ n -1 个数增加1和1个数减少1其实是等效的

```java
/**
 * @author: ffzs
 * @Date: 2021/10/20 上午7:11
 */
public class Solution {

    public int minMoves(int[] nums) {
        int min = nums[0], sum = 0;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            sum += num - min;
        }
        return sum;
    }

}
```

![image-20211020074525479](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211020074525479.png)