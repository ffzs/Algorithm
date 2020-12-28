## [188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)

## 题目

给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 

```java
示例 1：

输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2：

输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
```

```java
提示：

0 <= k <= 109
0 <= prices.length <= 1000
0 <= prices[i] <= 1000
```


链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv

## 解题记录

+ 通过动态规划获取结果
+ 主要逻辑和之前的买卖股票基本差不多
+ 这次多了设定的买卖次数k， 遍历k取不同值得时候获取的最终值，并取最大的情况

```java
/**
 * @author: ffzs
 * @Date: 2020/12/28 下午8:02
 */


public class Solution {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        k = Math.min(k, n/2);

        int[] buy = new int[k + 1], sell = new int[k + 1];
        for (int i = 0; i <= k; i++) buy[i] = -prices[0];


        for (int i = 1; i < n; i++) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }

        int res = 0;
        for (int i : sell) {
            if (i > res) res = i;
        }
        return res;
    }
}
```



![image-20201228214041199](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201228214041199.png)