## [684. 冗余连接](https://leetcode-cn.com/problems/redundant-connection/)

## 题目

在本问题中, 树指的是一个连通且无环的无向图。

输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。

结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。

返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。



```java
示例 1：

输入: [[1,2], [1,3], [2,3]]
输出: [2,3]
解释: 给定的无向图为:
  1
 / \
2 - 3
示例 2：

输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
输出: [1,4]
解释: 给定的无向图为:
5 - 1 - 2
    |   |
    4 - 3
```



```java
注意:

输入的二维数组大小在 3 到 1000。
二维数组中的整数在1到N之间，其中N是输入数组的大小。
更新(2017-09-26):
我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。


```

链接：https://leetcode-cn.com/problems/redundant-connection


## 解题记录

+ 由于是无向图，那么可以通过搜索来判断联通性
+ 说到联通性，就像到了并查集，可以通过并查集来确定边是否联通，如果一个边之前已将联通，那么说明这个边是多余的

```java
/**
 * @author: ffzs
 * @Date: 2021/1/13 下午7:37
 */

public class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] father = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            father[i] = i;
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (find(father, a) != find(father, b)) merge(father, a, b);
            else return edge;
        }
        return new int[0];
    }

    private int find (int[] f, int i) {
        if (f[i] != i) f[i] = find(f, f[i]);
        return f[i];
    }

    private void merge (int[] f, int i, int j) {
        f[find(f, i)] = find(f, j);
    }

}
```

![image-20210113213819426](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210113213819426.png)