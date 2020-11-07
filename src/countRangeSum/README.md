## [327. 区间和的个数](https://leetcode-cn.com/problems/count-of-range-sum/)

## 题目

给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。

说明:
最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。

```java
示例:

输入: nums = [-2,5,-1], lower = -2, upper = 2,
输出: 3 
解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
```


链接：https://leetcode-cn.com/problems/count-of-range-sum

## 解题记录

+ 暴力解法，直接双循环
+ 注意求sum的时候使用long

```java
/**
 * @author: ffzs
 * @Date: 2020/11/7 上午10:12
 */
public class Solution2 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for(int j = i; j>=0; j--) {
                sum += nums[j];
                if (sum >= lower && sum <= upper) res ++;
            }
        }
        return res;
    }

}
```

![image-20201107101740032](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201107101740032.png)

## 进阶

+ 通过前缀树和分支排序处理
+ 在排序过程中通过两两比对获取区间的和
+ 由于是排序的只要找到符合要求区间的左右index，可以获取index之间的个数

```java
/**
 * @author: ffzs
 * @Date: 2020/11/7 上午8:30
 */
public class Solution {
    int res = 0;
    int lower, upper;
    long[] sums;
    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        sums = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        sort(new long[sums.length], 0, nums.length);
        return res;
    }


    private void sort (long[] tmp, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) >>> 1;

        sort(tmp, left, mid);
        sort(tmp, mid + 1, right);
        merge(tmp, left, mid ,right);
    }

    private void merge(long[] tmp, int left, int mid, int right) {
        if (right + 1 - left >= 0) System.arraycopy(sums, left, tmp, left, right + 1 - left);

        int i = left, j = mid + 1;
        int low = mid + 1, up = mid + 1;

        for (int k = left; k <= right; k++) {
            // 找到[lower, upper] 的左index
            while (low <= right && tmp[low] - tmp[i] < lower) low ++;
            // 找到[lower, upper] 的右index
            while (up <= right && tmp[up] - tmp[i] <= upper) up ++;

            if (i > mid) {
                sums[k] = tmp[j++];
            } else if (j > right) {
                sums[k] = tmp[i++];
                res += up - low;
            } else if (tmp[i] > tmp[j]) {
                sums[k] = tmp[j++];
            } else {
                sums[k] = tmp[i++];
                res += up - low;
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {-2147483647,0,-2147483647,2147483647};
//        int[] nums = {-2,5,-1};
        int lower = -564, upper = 3864;
        Solution solution = new Solution();
        System.out.println(solution.countRangeSum(nums, lower, upper));
    }
}
```

![image-20201107111008384](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201107111008384.png)