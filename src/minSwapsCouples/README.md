## [765. 情侣牵手](https://leetcode-cn.com/problems/couples-holding-hands/)

## 题目

N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。

人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。

这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。

```java
示例 1:

输入: row = [0, 2, 1, 3]
输出: 1
解释: 我们只需要交换row[1]和row[2]的位置即可。
示例 2:

输入: row = [3, 2, 0, 1]
输出: 0
解释: 无需交换座位，所有的情侣都已经可以手牵手了。
```

```java
说明:

len(row) 是偶数且数值在 [4, 60]范围内。
可以保证row 是序列 0...len(row)-1 的一个全排列。
```


链接：https://leetcode-cn.com/problems/couples-holding-hands

## 解题记录

+ 分析错配情况，2对错配交换1次，3对错配交换2次，4对错配的话可能是22错配也可能是4对错配，22错配归根结底还是2对错配
+ 也就是说交换次数为错配对数-1
+ 可以通过并查集来去定错配情况，获取错配对数，每错配一对就减去1
+ 最后再通过总对数相减获得交换情况

```java
/**
 * @author: ffzs
 * @Date: 2021/2/14 上午9:12
 */

class UnionFind {
    private int[] f;
    private int count;

    public UnionFind(int n) {
        this.count = n;
        this.f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
    }

    public int find(int i) {
        if (f[i] != i) f[i] = find(f[i]);
        return f[i];
    }

    public void union (int i, int j) {
        int fi = find(i), fj = find(j);
        if (fi == fj) return;
        f[fi] = fj;
        count--;
    }

    public int getCount () {
        return this.count;
    }
}

public class Solution {

    public int minSwapsCouples(int[] row) {
        int n = row.length;
        UnionFind uni = new UnionFind(n/2);
        for (int i = 0; i < n; i += 2) {
            uni.union(row[i]/2, row[i+1]/2);
        }

        return n/2 - uni.getCount();
    }
}
```

![image-20210214100053279](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210214100053279.png)