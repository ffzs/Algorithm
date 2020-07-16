## [785. 判断二分图](https://leetcode-cn.com/problems/is-graph-bipartite/)

## 题目

给定一个无向图graph，当这个图为二分图时返回true。

如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。

graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。



```java
示例 1:
输入: [[1,3], [0,2], [1,3], [0,2]]
输出: true
解释: 
无向图如下:
0----1
|    |
|    |
3----2
我们可以将节点分成两组: {0, 2} 和 {1, 3}。
```

```java
示例 2:
输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
输出: false
解释: 
无向图如下:
0----1
| \  |
|  \ |
3----2
我们不能将节点分割成两个独立的子集。
```

```java
注意:

graph 的长度范围为 [1, 100]。
graph[i] 中的元素的范围为 [0, graph.length - 1]。
graph[i] 不会包含 i 或者有重复的值。
图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
```



链接：https://leetcode-cn.com/problems/is-graph-bipartite



## 解题记录

+ 通过染色法进行判断
+ 遍历邻接表中数组
+ 没有颜色的节点，通过1进行标记
+ 遍历该节点相连的节点，如果没有染色的话那么标记为-1，证明该节点为另一集合
+ 如果染色了，且不是对应集合的数值，那么返回false

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/7/16
 */
public class Solution2 {
    static int[] step;
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        step = new int[n];
        for (int i = 0; i < n; i++) {
            if (step[i] == 0) {
                if (!dfs(i, 1, graph)) return false;
            }
        }
        return true;
    }

    private static boolean dfs(int i, int c, int[][] graph) {
        step[i] = c;
        for (int i1 : graph[i]) {
            if (step[i1] == 0) {
                if (!dfs(i1, -c, graph)) return false;
            }
            else if (step[i1] != -c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
}

```



![image-20200716101447219](README.assets/image-20200716101447219.png)