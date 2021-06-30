## LCP 07. 传递信息

## 题目

小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：

有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。

```java
示例 1：

输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3

输出：3

解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。

示例 2：

输入：n = 3, relation = [[0,2],[2,1]], k = 2

输出：0

解释：信息不能从小 A 处经过 2 轮传递到编号 2
```



```java
限制：

2 <= n <= 10
1 <= k <= 5
1 <= relation.length <= 90, 且 relation[i].length == 2
0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i
```

[1]


链接：https://leetcode-cn.com/problems/chuan-di-xin-xi

## 解题记录

+ 优先构建链接关系，然后通过遍历所有关系找到所有满足情况的

```java
/**
 * @author: ffzs
 * @Date: 2021/7/1 上午7:21
 */
public class Solution {

    int res = 0;
    List<Integer>[] map;
    int n, k;
    public int numWays(int n, int[][] relation, int k) {
        this.n = n;
        this.k = k;
        map =  new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] ints : relation) {
            map[ints[0]].add(ints[1]);
        }
        dfs(0, 0);
        return res;
    }

    private void dfs(int idx, int level) {
        if (level == k) {
            if (idx == n-1) res++;
            return;
        }

        for (int i : map[idx]) {
            dfs(i, level+1);
        }
    }

}
```

![image-20210701075108582](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210701075108582.png)

+ 本题目给定了k，而且只要求返回个数，使用动态规划更简单一些

