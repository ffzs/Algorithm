## 446. 等差数列划分 II - 子序列

## 题目

给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。

如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。

例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
再例如，[1, 1, 2, 5, 7] 不是等差序列。
数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。

例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
题目数据保证答案是一个 32-bit 整数。

 

```java
示例 1：

输入：nums = [2,4,6,8,10]
输出：7
解释：所有的等差子序列为：
[2,4,6]
[4,6,8]
[6,8,10]
[2,4,6,8]
[4,6,8,10]
[2,4,6,8,10]
[2,6,10]
示例 2：

输入：nums = [7,7,7,7,7]
输出：16
解释：数组中的任意子序列都是等差子序列。
```



```java
提示：

1  <= nums.length <= 1000
-231 <= nums[i] <= 231 - 1
```


链接：https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence

## 解题记录

+ 动态规划求解
+ 通过`dp[i][j]`表是以`i， j`为起始的子数组的个数
+ `num[i] - num[j] = num[j] - num[l] -> num[l] = num[j]*2 -num[i]`
+ 遍历每一种情况，然后加到res中即可

```java
/**
 * @author: ffzs
 * @Date: 2021/8/11 上午6:51
 */
public class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        Map<Long, Integer>[] f= new Map[n];
        for (int i = 0; i < n; i++) f[i] = new HashMap<>();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long d = (long) nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                res += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return res;
    }

    public int numberOfArithmeticSlices2(int[] nums) {
        int n = nums.length;
        int[][] dp= new int[n][n];
        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long k = (long)nums[i];
            if (!map.containsKey(k)) map.put(k, new ArrayList<>());
            map.get(k).add(i);
        }

        int res = 0;
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                List<Integer> lst = map.getOrDefault((2*(long)nums[j] - nums[i]), null);
                if (lst != null) {
                    for (int l : lst) {
                        if (l < j) dp[i][j] += dp[j][l] + 1;
                    }
                }
                res += dp[i][j];
            }
        }
        return res;
    }

}
```

![image-20210811072613204](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210811072613204.png)