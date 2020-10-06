## [834. 树中距离之和](https://leetcode-cn.com/problems/sum-of-distances-in-tree/)

## 题目

给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。

第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。

返回一个表示节点 i 与其他所有节点距离之和的列表 ans。

```java
示例 1:

输入: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
输出: [8,12,6,10,10,10]
解释: 
如下为给定的树的示意图：
  0
 / \
1   2
   /|\
  3 4 5

我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5) 
也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
```

```java
说明: 1 <= N <= 10000
```


链接：https://leetcode-cn.com/problems/sum-of-distances-in-tree

## 解题记录

+ 因为这其实是一个图，严格意义上讲，哪个节点都可以作为根节点存在，这里设置root为0
+ 分为两步，第一步，通过节点关系获取一个表
+ 通过遍历表获取每一个节点其下节点的数量以及距离
+ 首先计算出0节点与其他节点之间的距离总和
+ 然后通过0节点向其他节点相位移动会可以根据移动的情况计算出距离更改情况，进而直接从0节点的总和情况计算出其他节点情况

```java
/**
 * @author: ffzs
 * @Date: 2020/10/6 上午7:06
 */
public class Solution {

    Map<Integer, Integer> distanceMap;
    Map<Integer, Integer> countMap;
    List<List<Integer>> tree;
    List<List<Integer>> tree2;
    int[] res;
    boolean[] mark;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        res = new int[N];
        if (N == 1) return res;
        distanceMap = new HashMap<>();
        countMap = new HashMap<>();
        tree = new ArrayList<>();
        tree2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
            tree2.add(new ArrayList<>());
        }
        int root = 0;
        mark = new boolean[N];
        mark[root] = true;
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }
        dfs(root);
        res[root] = distanceMap.get(root);

        Deque<Integer> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                int baseSum = res[cur];
                for (Integer integer : tree2.get(cur)) {
                    int subNode = countMap.get(integer);
                    res[integer] = baseSum - subNode + (N - subNode - 2);
                    queue.add(integer);
                }
            }
        }
        return res;
    }

    private int[] dfs (int root) {
        int[] ret = new int[2];
        for (Integer integer : tree.get(root)) {
            if (!mark[integer]) {
                mark[integer] = true;
                tree2.get(root).add(integer);
                int[] subRet =dfs(integer);
                ret[1] += subRet[1];
                ret[0] += subRet[0];
                ret[0] ++;
            }
        }
        ret[1] += ret[0];
        countMap.put(root, ret[0]);
        distanceMap.put(root, ret[1]);
        return ret;
    }
}

class Test {
    public static void main(String[] args) {
//        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
//        int[][] edges = {{2,1}, {0,2}};
        int[][] edges = {{1,2}, {3,2}, {3, 0}};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sumOfDistancesInTree(4, edges)));
    }
}
```

![image-20201006120153243](README.assets/image-20201006120153243.png)