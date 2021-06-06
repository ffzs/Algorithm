## 474. 一和零

## 题目

给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。

如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

```java
示例 1：

输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出：4
解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
示例 2：

输入：strs = ["10", "0", "1"], m = 1, n = 1
输出：2
解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
```



```java
提示：

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] 仅由 '0' 和 '1' 组成
1 <= m, n <= 100
```


链接：https://leetcode-cn.com/problems/ones-and-zeroes

## 解题记录

+ 通过动态规划求解，背包问题，通过一个三位数组来进行存储
+ `dp[i][j][k]`其中i代表第几个字符串，j表示0的个数，j代表1的个数
+ 如果遇到字符串中0的个数c0大于j，或是1的个数c1大于k，那么不可能符合条件，直接继承i-1
+ else 的话可以选择也可以不选，选取两种情况中的最大值也就是`dp[i-1][j-c0][k-c1] + 1`



```java
/**
 * @author: ffzs
 * @Date: 2021/6/6 下午3:28
 */
public class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int c0 = 0, c1 = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') c0++;
                else c1++;
            }
            for (int j = m; j >= c0; --j) {
                for (int k = n; k >= c1; --k) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - c0][k - c1] + 1);
                }
            }

        }

        return dp[m][n];
    }
}
```

![image-20210606162023481](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210606162023481.png)