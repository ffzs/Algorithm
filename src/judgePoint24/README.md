## [679. 24 点游戏](https://leetcode-cn.com/problems/24-game/)

## 题目

你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。

```JAVA
示例 1:

输入: [4, 1, 8, 7]
输出: True
解释: (8-4) * (7-1) = 24
```

```java
示例 2:

输入: [1, 2, 1, 2]
输出: False
```

```java
注意:

除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允许的。
你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。
```


链接：https://leetcode-cn.com/problems/24-game

## 解题记录

+ 直接穷举法，4个数，选取两个数加减乘除获得的新数，得到三个数，重复上面操作得到一个数判断是否为24
+ 因为有除法要可能不是直接等于24,要判断误差

```java
/**
 * @author: ffzs
 * @Date: 2020/8/22 上午10:40
 */

public class Solution {
    public boolean judgePoint24(int[] nums) {
        int product = 1;
        boolean noOne = true;
        double[] numsDouble = new double[4];
        for (int i=0; i< 4; ++i) {
            product *= nums[i];
            if (nums[i]==1) noOne = false;
            numsDouble[i] = nums[i];
        }
        if (product<24 && noOne) return false;
        if (product == 24) return true;
        return dfs(numsDouble, 3);
    }

    private boolean dfs (double[] nums, int n) {
        if (n==0) return Math.abs(nums[0] - 24) < 1e-6;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                double[] subNum = new double[n];
                int idx = 0;
                for (int k = 0; k < nums.length; k++) {
                    if (k != i && k != j) {
                        subNum[idx] = nums[k];
                        idx ++;
                    }
                }
                boolean isValid;
                subNum[idx] = nums[i] + nums[j];
                isValid = dfs(subNum,n-1);
                if (!isValid) {
                    subNum[idx] = nums[i] - nums[j];
                    isValid = dfs(subNum,n-1);
                }
                if (!isValid) {
                    subNum[idx] = nums[j] - nums[i];
                    isValid = dfs(subNum,n-1);
                }
                if (!isValid) {
                    subNum[idx] = nums[j] * nums[i];
                    isValid = dfs(subNum,n-1);
                }
                if (!isValid && nums[i] !=0) {
                    subNum[idx] = nums[j] / nums[i];
                    isValid = dfs(subNum,n-1);
                }
                if (!isValid && nums[j] !=0) {
                    subNum[idx] = nums[i] / nums[j];
                    isValid = dfs(subNum,n-1);
                }
                if (isValid) return true;
            }
        }
        return false;
    }
}
```

![image-20200822145730923](README.assets/image-20200822145730923.png)