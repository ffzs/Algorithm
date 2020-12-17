## [714. 买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)

## 题目

给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

```java
示例 1:

输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
输出: 8
解释: 能够达到的最大利润:  
在此处买入 prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
```

```java
注意:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
```


链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee

## 解题记录

+ 对于股票维护两个状态，一个是买入一个是持有
+ 买入状态维持持有和卖出的较大值，表示的是不再持有的最大利润
+ 持有状态维护继续持有，或是买入的最大值，表示持有的最大利润

```java
/**
 * @author: ffzs
 * @Date: 2020/12/17 上午8:46
 */
public class Solution2 {

    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
```

![image-20201217085429413](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201217085429413.png)