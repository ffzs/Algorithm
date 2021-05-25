## 1787. 使所有区间的异或结果为零

## 题目

给你一个整数数组 nums 和一个整数 k 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。

返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。

```java
示例 1：

输入：nums = [1,2,0,3,0], k = 1
输出：3
解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
示例 2：

输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
输出：3
解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
示例 3：

输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
输出：3
解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]
```



```java
提示：

1 <= k <= nums.length <= 2000
0 <= nums[i] < 210
```


链接：https://leetcode-cn.com/problems/make-the-xor-of-all-segments-equal-to-zero

## 解题记录

+ 经观察可以看出，想要每个k窗口的异或和都为0,那么一定是由k为一个周期的循环数值
+ 要求出最少更改情况，我们可以通过求某一个固定位置的数值的出现情况进行优化，记录每次异或对应值的个数, 对之前的情况进行累加
+ 更改的个数最坏是size个，但是出现的值得化需要减去出现的个数
+ 最后输出异或和为0的值

```java
/**
 * @author: ffzs
 * @Date: 2021/5/25 上午7:50D
 */
public class Solution {

    public int minChanges(int[] nums, int k) {
        int len = 1 << 10, INF = Integer.MAX_VALUE >> 1;

        int n = nums.length;
        int[] f = new int[len];
        Arrays.fill(f, INF);

        f[0] = 0;

        for (int i = 0; i < k; i++) {
            Map<Integer, Integer> counter = new HashMap<>();
            int size = 0;
            for (int j = i; j < n; j+=k) {
                counter.put(nums[j], counter.getOrDefault(nums[j], 0) + 1);
                size++;
            }

            int min = INF;
            for (int j : f) {
                min = Math.min(j, min);
            }
            int[] g = new int[len];

            Arrays.fill(g, min + size);

            for (int j = 0; j < len; j++) {
                for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                    int x = entry.getKey(), c = entry.getValue();
                    g[j] = Math.min(g[j], f[j ^ x] - c + size);
                }
            }
            f = g;
        }
        return f[0];
    }

}
```

![image-20210525195504697](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210525195504697.png)