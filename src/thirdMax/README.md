## 414. 第三大的数

## 题目

给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。

```java
示例 1：

输入：[3, 2, 1]
输出：1
解释：第三大的数是 1 。
示例 2：

输入：[1, 2]
输出：2
解释：第三大的数不存在, 所以返回最大的数 2 。
示例 3：

输入：[2, 2, 3, 1]
输出：1
解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
```

```java
提示：

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1


进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
```


链接：https://leetcode-cn.com/problems/third-maximum-number

## 解题记录

+ 优先排序，然后遍历数组获取去重后的第三大的值

```java
/**
 * @author: ffzs
 * @Date: 2021/10/6 上午7:02
 */
public class Solution {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];
        int cnt = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] == nums[i-1]) continue;
            else {
                cnt += 1;
                if (cnt == 3) return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
```

![image-20211006071328150](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211006071328150.png)