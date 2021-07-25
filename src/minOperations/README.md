## 1713. 得到子序列的最少操作次数

## 题目

给你一个数组 target ，包含若干 互不相同 的整数，以及另一个整数数组 arr ，arr 可能 包含重复元素。

每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加 3 得到 [1,4,3,1,2] 。你可以在数组最开始或最后面添加整数。

请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。

一个数组的 子序列 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的子序列（加粗元素），但 [2,4,2] 不是子序列。

 

```java
示例 1：

输入：target = [5,1,3], arr = [9,4,2,3,4]
输出：2
解释：你可以添加 5 和 1 ，使得 arr 变为 [5,9,4,1,2,3,4] ，target 为 arr 的子序列。
示例 2：

输入：target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
输出：3
```



```java
提示：

1 <= target.length, arr.length <= 105
1 <= target[i], arr[i] <= 109
target 不包含任何重复元素。
```


链接：https://leetcode-cn.com/problems/minimum-operations-to-make-a-subsequence

## 解题记录

+ 转化为求两个数组的最大公有子序列
+ 由于target比对arr的时候要保证顺序，因此获取到每个target在arr中的index，并保持一个递增序列
+ 由于同样位置的数值一定越小越好，通过二分法搜索获取每个val的位置进行数值上的替换即可

```java
/**
 * @author: ffzs
 * @Date: 2021/7/26 上午6:07
 */
public class Solution {

    public int minOperations(int[] target, int[] arr) {
        int n = target.length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(target[i], i);

        List<Integer> lst = new ArrayList<>();
        int[] tmp = new int[n];
        int len = 0;
        for (int i : arr) {
            if (map.containsKey(i)) {
                int idx = map.get(i);
                if (len == 0 || tmp[len-1] < idx) {
                    tmp[len++] = idx;
                }
                else {
                    tmp[binarySearch(tmp, idx, len)] = idx;
                }
            }
        }
        return n - len;
    }


    private int binarySearch (int[] tmp, int target, int len) {
        int l = 0, h = len-1;
        while (l < h) {
            int mid = (l + h) >>> 1;
            if (tmp[mid] < target) l = mid + 1;
            else h = mid;
        }
        return l;
    }
}
```



![image-20210726070054973](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210726070054973.png)