## 1711. 大餐计数

## 题目

大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。

你可以搭配 任意 两道餐品做一顿大餐。

给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余。

注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。

```java
示例 1：

输入：deliciousness = [1,3,5,7,9]
输出：4
解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
示例 2：

输入：deliciousness = [1,1,1,3,3,3,7]
输出：15
解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
```



```java
提示：

1 <= deliciousness.length <= 105
0 <= deliciousness[i] <= 220
```


链接：https://leetcode-cn.com/problems/count-good-meals

## 解题记录

+ 通过hash记录每个口味的菜品数
+ 每次遍历到口味最大值的2的幂的情况为止，统计所有可能的情况

```java
/**
 * @author: ffzs
 * @Date: 2021/7/7 上午6:54
 */
public class Solution {

    public int countPairs(int[] deliciousness) {
        int MOD = 1_000_000_000 + 7;
        int max = deliciousness[0], min = deliciousness[1];
        for (int i : deliciousness) {
            if (i > max) max = i;
            else if (i < min) min = i;
        }

        int[] map = new int[max - min + 1];
        int res = 0;
        for (int v : deliciousness) {
            for (int i = 1; ; i <<= 1) {
                int x = i - v;
                if (x > max) break;
                if (x < min) continue;
                res = (res + map[x - min]) % MOD;
            }
            map[v - min] ++;
        }
        return res;
    }
}
```

![image-20210707071621102](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210707071621102.png)