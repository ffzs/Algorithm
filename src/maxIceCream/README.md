## 1833. 雪糕的最大数量

## 题目

夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。

商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。

给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。

注意：Tony 可以按任意顺序购买雪糕。

```java
示例 1：

输入：costs = [1,3,2,4,1], coins = 7
输出：4
解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
示例 2：

输入：costs = [10,6,8,7,7,8], coins = 5
输出：0
解释：Tony 没有足够的钱买任何一支雪糕。
示例 3：

输入：costs = [1,6,3,1,2,5], coins = 20
输出：6
解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18 。
```

```java
提示：

costs.length == n
1 <= n <= 105
1 <= costs[i] <= 105
1 <= coins <= 108
```


链接：https://leetcode-cn.com/problems/maximum-ice-cream-bars

## 解题记录

+ 贪心算法
+ 通过将雪糕价格排序，优先购买便宜的

```java
/**
 * @author: ffzs
 * @Date: 2021/7/2 上午6:55
 */
public class Solution {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int cost : costs) {
            if (coins >= cost) coins-=cost;
            else break;
            res++;
        }
        return res;
    }

}
```

![image-20210702070936473](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210702070936473.png)

+ 通过堆计算，维护一个堆内雪糕总和，如果雪糕价格超过硬币数，那么比较堆内最大和目前雪糕的价钱，将更小的放进去

```java
public int maxIceCream2(int[] costs, int coins) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int sum = 0;
    for (int cost : costs) {
        if (cost + sum <= coins){
            queue.offer(-cost);
            sum += cost;
        }
        else if (!queue.isEmpty() && (-queue.peek()) > cost) {
            sum += queue.poll();
            sum += cost;
            queue.offer(-cost);
        }
    }
    return queue.size();
}
```

![image-20210702071717715](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210702071717715.png)