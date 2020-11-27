# [454. 四数相加 II](https://leetcode-cn.com/problems/4sum-ii/)

## 题目

给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 $-2^{28}$ 到 $2^{28 - 1}$ 之间，最终结果不会超过 $2^{31 - 1}$ 。

例如:

```java
输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2
    
解释:
两个元组如下:

1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
```




链接：https://leetcode-cn.com/problems/4sum-ii

## 解题记录

+ 优先通过前两个数组得到所有可能情况，存储到map中
+ 之后通过后两个数组加和的情况判断map中是否存在加和为0的情况
+ 通过最终总和情况
+ 为了节省时间可以优先将map的大小设定为最大，避免出现扩容的情况

```java
/**
 * @author: ffzs
 * @Date: 2020/11/27 上午7:24
 */
public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(n * n, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = A[i] + B[j];
                map.merge(cur, 1, Integer::sum);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = C[i] + D[j];
                if (map.containsKey(-cur)) res += map.get(-cur);
            }
        }

        return res;
    }
}
```

![image-20201127080959595](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201127080959595.png)