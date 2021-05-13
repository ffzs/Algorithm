## 1269. 停在原地的方案数

## 题目

有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。

每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。

给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。

由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。

```java
示例 1：

输入：steps = 3, arrLen = 2
输出：4
解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
向右，向左，不动
不动，向右，向左
向右，不动，向左
不动，不动，不动
示例  2：

输入：steps = 2, arrLen = 4
输出：2
解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
向右，向左
不动，不动
示例 3：

输入：steps = 4, arrLen = 2
输出：8
```



```java
提示：

1 <= steps <= 500
1 <= arrLen <= 10^6
```


链接：https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps

## 解题记录

+ 通过动态规划求解，`dp[i][j]  代表走了i 步位置为j的情况数` 那么 `dp[i][j]=dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1]`就是说可以通过j-1向右移，j位置不动，j + 1向左移动得到
+ 这里j的大小最大不能超过arrlen-1 或是 steps
+ 为了方便处理边界，我们j纬度上下添加两行0避免判断j-1和j+1的边界

```java
/**
 * @author: ffzs
 * @Date: 2021/5/13 下午6:34
 */
public class Solution {

    public int numWays(int steps, int arrLen) {
        final int MODULE_ = 1000000000 + 7;
        int len = Math.min(arrLen - 1, steps);
        int[][] dp = new int[steps + 1][len + 3];
        dp[0][1] = 1;

        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= len; j++) {
                dp[i][j+1] = ((dp[i-1][j] + dp[i-1][j+1]) % MODULE_ + dp[i-1][j+2]) % MODULE_;
            }
        }
        return dp[steps][1];
    }
}
```

![image-20210513192816184](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210513192816184.png)