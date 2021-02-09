## [992. K 个不同整数的子数组](https://leetcode-cn.com/problems/subarrays-with-k-different-integers/)

## 题目

给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。

（例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）

返回 A 中好子数组的数目。



```java
示例 1：

输入：A = [1,2,1,2,3], K = 2
输出：7
解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
示例 2：

输入：A = [1,2,1,3,4], K = 3
输出：3
解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
```



```java
提示：

1 <= A.length <= 20000
1 <= A[i] <= A.length
1 <= K <= A.length
```


链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers

## 解题记录

+ 通过滑动窗口[left，right]获取窗口中不重复数值个数不大于N的长度，故以left开始的数组个数为right-left
+ 再获取不大于N-1的个数，通过两种情况相减的话获得个数恰巧为N的情况

```java
/**
 * @author: ffzs
 * @Date: 2021/2/9 上午8:15
 */
public class Solution {

    public int subarraysWithKDistinct(int[] A, int K) {
        return subarraysUnderKDistinct(A, K) - subarraysUnderKDistinct(A, K - 1);
    }

    private int subarraysUnderKDistinct(int[] A, int K){
        int n = A.length;
        int left = 0, right = 0;
        int count = 0, res = 0;
        int[] counter = new int[n + 1];

        while (right < n) {
            if (counter[A[right]] == 0) count++;
            counter[A[right]]++;
            right++;

            while (count > K) {
                counter[A[left]]--;
                if (counter[A[left]] == 0) count--;
                left++;
            }
            res += right - left;
        }
        return res;
    }

}
```

![image-20210209084242048](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210209084242048.png)