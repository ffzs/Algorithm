## [486. 预测赢家](https://leetcode-cn.com/problems/predict-the-winner/)

## 题目

给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。

给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。

 

```java
示例 1：

输入：[1, 5, 2]
输出：False
解释：一开始，玩家1可以从1和2中进行选择。
如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
因此，玩家 1 永远不会成为赢家，返回 False 。
```



```java
示例 2：

输入：[1, 5, 233, 7]
输出：True
解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
     最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
```



```java
提示：

1 <= 给定的数组长度 <= 20.
数组里所有分数都为非负数且不会大于 10000000 。
如果最终两个玩家的分数相等，那么玩家 1 仍为赢家。
```



链接：https://leetcode-cn.com/problems/predict-the-winner


## 解题记录

设定`step[left][right]`为在left~right这段区间中玩家1和玩家2的差值，当前玩家1选着

+ 通过递归，选左边为`leftScore = nums[left] - dfs(left+1, right);`
+ 选右边`rightScore = nums[right] - dfs(left, right-1);`
+ 最优为差值最大

```java
/**
 * @author: ffzs
 * @Date: 2020/9/1 上午7:10
 */
public class Solution {
    int[][] step;
    int[] nums;
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        step = new int[n][n];
        this.nums = nums;
        for (int[] ints : step) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }

        return dfs(0, n-1) >= 0;
    }

    private int dfs (int left, int right) {
        if (left > right) return 0;

        if (step[left][right] != Integer.MIN_VALUE) return step[left][right];

        int leftScore = nums[left] - dfs(left+1, right);
        int rightScore = nums[right] - dfs(left, right-1);
        int score = Math.max(leftScore, rightScore);
        step[left][right] = score;
        return score;
    }
}
```

![image-20200901085001516](README.assets/image-20200901085001516.png)

+ 递归是正着想，机器倒着做
+ 动态规划化是倒着想，机器正着做



```java
/**
 * @author: ffzs
 * @Date: 2020/9/1 上午8:37
 */

public class Solution2 {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        // 先填上分界线
        for (int i = 0; i < n; i++) dp[i][i] = nums[i];
        // 因为要获得 ij ,因此需要优先获取i+1,j-1等，所以从后向前获取
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                dp[i][j] = Math.max((nums[i] - dp[i+1][j]), (nums[j] - dp[i][j-1]));
            }
        }
        return dp[0][n-1] >= 0;
    }
}
```

![image-20200901085026406](README.assets/image-20200901085026406.png)