## [312. 戳气球](https://leetcode-cn.com/problems/burst-balloons/)

## 题目

有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums气球。如果你戳破气球 i ，就可以获得nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。

求所能获得硬币的最大数量。

```java
说明:

你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
0 ≤ n ≤ 500,   0 ≤ nums[i] ≤ 100
```



```java
示例:

输入: [3,1,5,8]
输出: 167 
解释: nums = [3,1,5,8] --> [3,5,8] --> [3,8] -->[8]-->[]
           coins =  3*1*5  +  3*5*8  +  1*3*8  + 1*8*1 = 167
```


链接：https://leetcode-cn.com/problems/burst-balloons



## 解题记录

+ 通过分治的方法进行计算
+ 设定i和j之间(不包括i,j)得到的最大金币为`def( i , j )`
+ 将i,j通过k进行二分得到：`def( i, j ) = def( i , k ) + def( k , j )+nums[i]*nums[ j]*nums[k] `
+ 因为i和i+1之间没有气球，因此`def( i , i+1 ) = 0`
+ 状态转移方程 `def( i, j ) = max { def( i , k ) + def( k , j )+nums[i]*nums[ j]*nums[k]  } | i<k<j` ，回归条件 `def( i , i+1 ) = 0`


```java

/**
 * @author: ffzs
 * @Date: 2020/7/19 上午7:59
 */

public class Solution {
    static int[] ns;
    static int[][] step;
    public static int maxCoins(int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        ns = new int[len+2];
        System.arraycopy(nums,0, ns, 1, len);
        ns[0] = ns[len+1] = 1;
        step = new int[len+2][len+2];

        return maxCoins(0, len+1);
    }

    private static int maxCoins (int l, int r) {
        if (l + 1 == r) return 0;   // l, l+1 之间没有气球，返回0
        if (step[l][r] != 0) return step[l][r];   // 访问过的直接返回

        int max = 0;
        for (int mid = l+1; mid < r; ++mid) {
            max = Math.max(max, maxCoins(l, mid) + maxCoins(mid, r) + ns[l]*ns[r]*ns[mid]);
        }
        step[l][r] = max;
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(maxCoins(nums));
    }
}

```

![image-20200719101317814](README.assets/image-20200719101317814.png)

## 进阶 动态规划

+ 思路跟分治方法基本相同
+ 将分治方法的递归更换为递推的方法
+ 状态方程依旧是：`def( i, j ) = def( i , k ) + def( k , j )+nums[i]*nums[ j]*nums[k] `

```java
/**
 * @author: ffzs
 * @Date: 2020/7/19 上午10:16
 */
public class Solution2 {
    public static int maxCoins(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] ns = new int[len + 2];
        System.arraycopy(nums, 0, ns, 1, len);
        ns[0] = ns[len+1] = 1;
        int[][] dp = new int[len+2][len+2];

        for (int i = len - 1; i >= 0; --i) {
            for (int j = i + 2; j <= len + 1; ++j) {
                if (dp[i][j] == 0) {
                    int max = 0;
                    for (int mid = i+1; mid < j; ++mid) {
                        max = Math.max(max, dp[i][mid]+dp[mid][j]+ns[i]*ns[j]*ns[mid]);
                    }
                    dp[i][j] = Math.max(dp[i][j], max);
                }
            }
        }
        return dp[0][len+1];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(maxCoins(nums));
    }
}
```

![image-20200719105326786](README.assets/image-20200719105326786.png)