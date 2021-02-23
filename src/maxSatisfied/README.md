## [1052. 爱生气的书店老板](https://leetcode-cn.com/problems/grumpy-bookstore-owner/)

## 题目

今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。

在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。

书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。

请你返回这一天营业下来，最多有多少客户能够感到满意的数量。

```java
示例：

输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
输出：16
解释：
书店老板在最后 3 分钟保持冷静。
感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
```

```java
提示：

1 <= X <= customers.length == grumpy.length <= 20000
0 <= customers[i] <= 1000
0 <= grumpy[i] <= 1
```


链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner

## 解题记录

+ 首先计算店主没有使用技能情况下能积攒多少的满意度
+ 其次通过滑动一个X长度的窗口，在窗口内部将原本是1的那部分加上，获取这部分的最大值
+ 然后返回之和

```java
/**
 * @author: ffzs
 * @Date: 2021/2/23 上午10:51
 */
public class Solution2 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
                customers[i] = 0;
            }
        }

        int res = 0, mask = 0;
        int i = 0;
        while (i < n) {
            mask += customers[i];
            if (i >= X-1) {
                res = Math.max(mask, res);
                mask -= customers[i - X + 1];
            }
            i++;
        }
        return res + sum;
    }
}
```

![image-20210223110954288](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210223110954288.png)