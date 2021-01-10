## [228. 汇总区间](https://leetcode-cn.com/problems/summary-ranges/)

## 题目

给定一个无重复元素的有序整数数组 nums 。

返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：

"a->b" ，如果 a != b
"a" ，如果 a == b


示例 1：

输入：nums = [0,1,2,4,5,7]
输出：["0->2","4->5","7"]
解释：区间范围是：
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
示例 2：

输入：nums = [0,2,3,4,6,8,9]
输出：["0","2->4","6","8->9"]
解释：区间范围是：
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
示例 3：

输入：nums = []
输出：[]
示例 4：

输入：nums = [-1]
输出：["-1"]
示例 5：

输入：nums = [0]
输出：["0"]


提示：

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
nums 中的所有值都 互不相同
nums 按升序排列


链接：https://leetcode-cn.com/problems/summary-ranges

## 解题记录

+ 简单的检查数组前后关系是否为连续的
+ 记录连续部分的前后指针
+ 最后判断如果指针相同和指针不同的情况

```java
/**
 * @author: ffzs
 * @Date: 2021/1/10 上午8:36
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        int i = 0, j;
        while (i < n) {
            j = i;
            while (j + 1 < n && nums[j] + 1 == nums[j+1]) j++;
            StringBuilder sb = new StringBuilder().append(nums[i]);
            if (i != j) sb.append("->").append(nums[j]);
            res.add(sb.toString());
            i = j + 1;
        }
        return res;
    }
}
```

![image-20210110100118178](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210110100118178.png)