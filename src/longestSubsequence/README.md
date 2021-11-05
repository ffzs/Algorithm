## 1218. 最长定差子序列

## 题目

给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。

子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。

```java
示例 1：

输入：arr = [1,2,3,4], difference = 1
输出：4
解释：最长的等差子序列是 [1,2,3,4]。
示例 2：

输入：arr = [1,3,5,7], difference = 1
输出：1
解释：最长的等差子序列是任意单个元素。
示例 3：

输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
输出：4
解释：最长的等差子序列是 [7,5,3,1]。
```

```java
提示：

1 <= arr.length <= 105
-104 <= arr[i], difference <= 104
```


链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference

## 解题记录

+ 通过动态规划求解
+ 通过$arr[i]-difference$获取对应的值加1为当前结尾为$arr[i]$情况的值

```java
/**
 * @author: ffzs
 * @Date: 2021/11/5 上午7:19
 */
public class Solution {

    public int longestSubsequence(int[] arr, int difference) {
        int res = 1;
        int[] map = new int[40001];
        for (int i : arr) {
            map[i + 20000] = map[i - difference + 20000] + 1;
            res = Math.max(res, map[i + 20000]);
        }
        return res;
    }
}

class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8};
        System.out.println(s.longestSubsequence(arr, 0));
    }
}
```

![image-20211105075925630](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211105075925630.png)