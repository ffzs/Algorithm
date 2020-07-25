## [410. 分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum/)

## 题目

给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。

```java
注意:
数组长度 n 满足以下条件:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
```



```java
示例:

输入:
nums = [7,2,5,10,8]
m = 2

输出:
18

解释:
一共有四种方法将nums分割为2个子数组。
其中最好的方式是将其分为[7,2,5] 和 [10,8]，
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
```


链接：https://leetcode-cn.com/problems/split-array-largest-sum

## 解题记录

+ 动态规划
+ `dp[i][j]`的内容记录的是，数组的前i个，被分成j组的最小每组最大值，i从小到大遍历，通过dp数组进行记录
+ i没增加1，之前的已经算过可以在dp数组中找到
+ 新的数组值得获取通过前缀和的方法

```java
/**
 * @author: ffzs
 * @Date: 2020/7/25 上午8:09
 */
public class Solution {
    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i < n; ++i) nums[i] += nums[i-1];
        for (int i = 0; i < n + 1; ++i) Arrays.fill(dp[i], nums[n-1]);

        dp[0][0] = 0;
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 1; j <= Math.min(i, m); ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < i; ++k) {
                    int nk = k==0? 0: nums[k-1];
                    min = Math.min(min, Math.max(dp[k][j-1], nums[i-1]-nk));
                }
                dp[i][j] = min;
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        System.out.println(splitArray(nums, 2));
    }
}

```

## 

![image-20200725094234356](README.assets/image-20200725094234356.png)

## 二分法

+ 通过枚举结果来判断是否符合分成m个数的方法
+ 结果的最小值不能小于 `sum/m` 定为left， sum定为right
+ 选取mid为结果
+ 更具mid结果进行分组，如果分组的情况大于给的m说明，mid小了，因此left = mid+1
+ 如果分的组小于m，说明mid大了，则right=mid；
+ 因为要求最小的mid，因此分组等于m，也要right=mid

```java
/**
 * @author: ffzs
 * @Date: 2020/7/25 上午9:46
 */
public class Solution2 {
    public static int splitArray(int[] nums, int m) {
        int r = 0, l = 0;
        for (int num : nums) {
            r += num;
            l = Math.max(l, num);
        }
        l = Math.max(l, r/m);
        while (l < r) {
            int mid = l+r >>> 1;
            if (isMatch(nums, mid, m)) r = mid;
            else l = mid + 1;
        }

        return l;
    }

    private static boolean isMatch(int[] nums, int mid, int m) {
        int sum = 0, count = 1;
        for (int num : nums) {
            if (sum + num > mid) {
                sum = num; count++;
            }
            else
                sum += num;
        }
        return count <= m;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        System.out.println(splitArray(nums, 2));
    }
}
```

![image-20200725101640936](README.assets/image-20200725101640936.png)