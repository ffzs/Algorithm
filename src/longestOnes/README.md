## [1004. 最大连续1的个数 III](https://leetcode-cn.com/problems/max-consecutive-ones-iii/)

## 题目

给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。

返回仅包含 1 的最长（连续）子数组的长度。

```java
示例 1：

输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
输出：6
解释： 
[1,1,1,0,0,1,1,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。
示例 2：

输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
输出：10
解释：
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。
```

```java
提示：

1 <= A.length <= 20000
0 <= K <= A.length
A[i] 为 0 或 1 
```


链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii

## 解题记录

+ 通过滑动窗口始终维护一个变换k个状态
+ 如果0的个数小于等于K，那么就将窗口右端右移
+ 如果0的个数大于K，那么将窗口的左端右移达到缩小窗口的目的



```java
/**
 * @author: ffzs
 * @Date: 2021/2/19 上午8:13
 */
public class Solution {

    public int longestOnes(int[] A, int K) {
        int n = A.length;
        int res = 0, count = 0;
        int left = 0, right = 0;

        while (right < n) {
            if (count <= K) {
                if (A[right] == 0) count++;
                if (count <= K) res = Math.max(right - left + 1, res);
                right++;
            }
            else {
                if (A[left] == 0) count--;
                left++;
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
//        int[] A = {0,0,0,1};
        System.out.println(solution.longestOnes(A, 2));
    }
}
```

![image-20210219213321343](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210219213321343.png)