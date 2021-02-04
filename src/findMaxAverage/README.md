## [643. 子数组最大平均数 I](https://leetcode-cn.com/problems/maximum-average-subarray-i/)

## 题目

给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

```java
示例：

输入：[1,12,-5,-6,50,3], k = 4
输出：12.75
解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
```

```java
提示：

1 <= k <= n <= 30,000。
所给数据范围 [-10,000，10,000]。
```


链接：https://leetcode-cn.com/problems/maximum-average-subarray-i

## 解题记录

+ 移动窗口，通过一个sum维护窗口内部的和
+ 获取到最大的和
+ 然后获取到对应的均值即可

```java
/**
 * @author: ffzs
 * @Date: 2021/2/4 上午8:51
 */
public class Solution {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, max;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i-k];
            max = Math.max(max, sum);
        }

        return (double)max/k;
    }

}
```

![image-20210204090148541](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210204090148541.png)