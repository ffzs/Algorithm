## [321. 拼接最大数](https://leetcode-cn.com/problems/create-maximum-number/)

## 题目

给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。

求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

说明: 请尽可能地优化你算法的时间和空间复杂度。

```java
示例 1:

输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]
示例 2:

输入:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
输出:
[6, 7, 6, 0, 4]
示例 3:

输入:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
输出:
[9, 8, 9]
```


链接：https://leetcode-cn.com/problems/create-maximum-number

## 解题记录

+ 根据长度将k分隔为两部分分别给nums1,和nums2
+ 通过单调栈分别获取nums1,nums2对应的数据，得到数据后在通过大小情况将数据合并

```java
/**
 * @author: ffzs
 * @Date: 2020/12/2 上午8:36
 */
public class Solution2 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] res = new int[k];
        for (int i = 0; i <= k && i <= n1; i++) {
            if (k - i >= 0 && k - i <= n2) {
                int[] tmp = merge(sub(nums1, i), sub(nums2, k - i));
                if (compare(tmp, 0, res, 0)) {
                    res = tmp;
                }
            }
        }
        return res;
    }

    private int[] sub(int[] nums, int k){
        int[] subNums = new int[k];
        int cur = 0, rem = nums.length - k;
        for (int num : nums) {
            while (cur > 0 && subNums[cur - 1] < num && rem > 0) {
                cur--;
                rem--;
            }
            if (cur < k) {
                subNums[cur++] = num;
            } else {
                rem--;
            }
        }
        return subNums;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int cur = 0, p1 = 0, p2 = 0;
        while (cur < nums1.length + nums2.length) {
            if (compare(nums1, p1, nums2, p2)) {
                res[cur++] = nums1[p1++];
            } else {
                res[cur++] = nums2[p2++];
            }
        }
        return res;
    }

    public boolean compare(int[] nums1, int i1, int[] nums2, int i2) {
        int x = nums1.length, y = nums2.length;
        while (i1 < x && i2 < y) {
            int difference = nums1[i1] - nums2[i2];
            if (difference != 0) return difference > 0;
            i1++;
            i2++;
        }
        return (x - i1) - (y - i2) > 0;
    }
}
```

![image-20201202090656518](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201202090656518.png)