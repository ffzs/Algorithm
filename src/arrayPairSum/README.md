## [561. 数组拆分 I](https://leetcode-cn.com/problems/array-partition-i/)

## 题目

给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到 n 的 min(ai, bi) 总和最大。

返回该 最大总和 。

```java
示例 1：

输入：nums = [1,4,3,2]
输出：4
解释：所有可能的分法（忽略元素顺序）为：

1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
   所以最大总和为 4
   示例 2：

输入：nums = [6,2,6,5,1,2]
输出：9
解释：最优的分法为 (2, 1), (2, 5), (6, 6). min(2, 1) + min(2, 5) + min(6, 6) = 1 + 2 + 6 = 9
```


提示：

$1 <= n <= 10^4$
nums.length == 2 * n
$-10^4 <= nums[i] <= 10^4$


链接：https://leetcode-cn.com/problems/array-partition-i

## 解题记录

+ 根据题意可知尽量把相近的放大一组可以获取尽量最大的情况
+ 首先进行快速排序，然后获取每一组中小的那个加和即可
+ 使用归并排序应该会更快一些

```java
/**
 * @author: ffzs
 * @Date: 2021/2/16 上午9:08
 */
public class Solution {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length / 2;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += nums[i*2];
        }
        return res;
    }

}
```

![image-20210216092607465](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210216092607465.png)