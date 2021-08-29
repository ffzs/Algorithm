## 528. 按权重随机选择

## 题目

给定一个正整数数组 w ，其中 w[i] 代表下标 i 的权重（下标从 0 开始），请写一个函数 pickIndex ，它可以随机地获取下标 i，选取下标 i 的概率与 w[i] 成正比。

例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3) = 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3) = 0.75（即，75%）。

也就是说，选取下标 i 的概率为 w[i] / sum(w) 。

 

```java
示例 1：

输入：
["Solution","pickIndex"]
[[[1]],[]]
输出：
[null,0]
解释：
Solution solution = new Solution([1]);
solution.pickIndex(); // 返回 0，因为数组中只有一个元素，所以唯一的选择是返回下标 0。
示例 2：

输入：
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
输出：
[null,1,1,1,1,0]
解释：
Solution solution = new Solution([1, 3]);
solution.pickIndex(); // 返回 1，返回下标 1，返回该下标概率为 3/4 。
solution.pickIndex(); // 返回 1
solution.pickIndex(); // 返回 1
solution.pickIndex(); // 返回 1
solution.pickIndex(); // 返回 0，返回下标 0，返回该下标概率为 1/4 。

由于这是一个随机问题，允许多个答案，因此下列输出都可以被认为是正确的:
[null,1,1,1,1,0]
[null,1,1,1,1,1]
[null,1,1,1,0,0]
[null,1,1,1,0,1]
[null,1,0,1,0,0]
......
诸若此类。
```



```java
提示：

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex 将被调用不超过 10000 次
```


链接：https://leetcode-cn.com/problems/random-pick-with-weight

## 解题记录

+ 前缀和累加权重
+ 随机获取权重，二分法进行搜索

```java
/**
 * @author: ffzs
 * @Date: 2021/8/30 上午6:49
 */
public class Solution {
    int[] w;
    int total;
    public Solution(int[] w) {
        this.w = w;
        for (int i = 1; i < w.length; i++) {
            this.w[i] += this.w[i-1];
        }
        total = this.w[w.length-1];
    }

    public int pickIndex() {
        int r = (int)(Math.random()*total) + 1;
        return binarySearch(r);
    }

    private int binarySearch(int i) {
        int l =0, r = w.length-1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (w[mid] < i) l = mid + 1;
            else r = mid;
        }
        return l;
    }

}
```

![image-20210830070401573](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210830070401573.png)