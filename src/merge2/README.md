## 88. 合并两个有序数组

## 题目

给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

```java
示例 1：

输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
示例 2：

输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
```

```java
提示：

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109
```


链接：https://leetcode-cn.com/problems/merge-sorted-array

## 解题记录

+ 直接通过一个缓存的数组用来缓存这些数据
+ 通过两个指针控制两个数组，进行比对，比较小的那些写入数组
+ 最后通过缓存数据刷新num1

```java
/**
 * @author: ffzs
 * @Date: 2021/4/5 下午2:48
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m + n];
        int mi = 0, ni = 0;

        for (int i = 0; i < tmp.length; i++) {
            if (mi > m- 1) tmp[i] = nums2[ni++];
            else if (ni > n - 1) tmp[i] = nums1[mi++];
            else tmp[i] = nums1[mi] > nums2[ni] ? nums2[ni++] : nums1[mi++];
        }

        System.arraycopy(tmp, 0, nums1, 0, tmp.length);
    }

}
```

 

![image-20210405152931017](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210405152931017.png)