## [947. 移除最多的同行或同列石头](https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/)

## 题目

n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。

如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。

给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。

```java
示例 1：

输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
输出：5
解释：一种移除 5 块石头的方法如下所示：
1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
   石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。
    
示例 2：
输入：stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
输出：3
解释：一种移除 3 块石头的方法如下所示：

1. 移除石头 [2,2] ，因为它和 [2,0] 同行。
2. 移除石头 [2,0] ，因为它和 [0,0] 同列。
3. 移除石头 [0,2] ，因为它和 [0,0] 同行。
   石头 [0,0] 和 [1,1] 不能移除，因为它们没有与另一块石头同行/列。
    
示例 3：
输入：stones = [[0,0]]
输出：0
解释：[0,0] 是平面上唯一一块石头，所以不可以移除它。
```



```java
提示：

1 <= stones.length <= 1000
0 <= xi, yi <= 104
不会有两块石头放在同一个坐标点上
```


链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column

## 解题记录

+ 同样是联通性问题，使用并查集解决
+ x相同，或是y相同的可以视为联通，一个石头的x,y视为联通
+ 由于并查集处理的是一维的数组，二维的x，y有可能是重复的，由于x，y最小为0，那么优先统计出x，y的最大值，新的yn = y + maxx+1

```java
/**
 * @author: ffzs
 * @Date: 2021/1/15 下午7:28
 */
public class Solution {

    public int removeStones(int[][] stones) {
        int maxX = 0, maxY = 0;
        for (int[] stone : stones) {
            maxX = Math.max(stone[0], maxX);
            maxY = Math.max(stone[1], maxY);
        }

        int[] father = new int[maxX + maxY + 2];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }

        for (int[] stone : stones) {
            int y = stone[1] + maxX + 1;
            int f1 = find(father, stone[0]);
            int f2 = find(father, y);
            if (f1 != f2) union(father, stone[0], y);
        }

        boolean[] tmp = new boolean[maxX + maxY + 2];
        int counter = 0;

        for (int[] stone : stones) {
            int f = find(father, stone[0]);
            if (!tmp[f]) {
                tmp[f] = true;
                counter++;
            }
        }

        return stones.length - counter;
    }

    private int find (int[] f, int i) {
        if (f[i] != i) f[i] = find(f, f[i]);
        return f[i];
    }

    private void union (int[] f, int i, int j) {
        f[find(f, j)] = find(f, i);
    }

}
```

![image-20210115211854043](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210115211854043.png)