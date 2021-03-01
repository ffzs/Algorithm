## [303. 区域和检索 - 数组不可变](https://leetcode-cn.com/problems/range-sum-query-immutable/)

## 题目

给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。

实现 NumArray 类：

NumArray(int[] nums) 使用数组 nums 初始化对象
int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）

```java
示例：

输入：
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
输出：
[null, 1, -1, -3]

解释：
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
```

```java
提示：

0 <= nums.length <= 104
-105 <= nums[i] <= 105
0 <= i <= j < nums.length
最多调用 104 次 sumRange 方法
```


链接：https://leetcode-cn.com/problems/range-sum-query-immutable

## 解题记录

+ 通过前缀和的方式处理数组
+ 首先通过累加处理数组
+ 然后通过给定的数组范围通过之和相减来获取范围和

```java
/**
 * @author: ffzs
 * @Date: 2021/3/1 上午9:19
 */
public class NumArray {
    private int[] res;

    public NumArray(int[] nums) {
        if (nums.length == 0) return;
        this.res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return res[j];
        return res[j] - res[i-1];
    }
}
```

![image-20210301094001067](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210301094001067.png)