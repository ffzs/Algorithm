## [1203. 项目管理](https://leetcode-cn.com/problems/sort-items-by-groups-respecting-dependencies/)

## 题目

公司共有 n 个项目和  m 个小组，每个项目要不无人接手，要不就由 m 个小组之一负责。

group[i] 表示第 i 个项目所属的小组，如果这个项目目前无人接手，那么 group[i] 就等于 -1。（项目和小组都是从零开始编号的）小组可能存在没有接手任何项目的情况。

请你帮忙按要求安排这些项目的进度，并返回排序后的项目列表：

同一小组的项目，排序后在列表中彼此相邻。
项目之间存在一定的依赖关系，我们用一个列表 beforeItems 来表示，其中 beforeItems[i] 表示在进行第 i 个项目前（位于第 i 个项目左侧）应该完成的所有项目。
如果存在多个解决方案，只需要返回其中任意一个即可。如果没有合适的解决方案，就请返回一个 空列表 。

 

```java
示例 1：

输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3,6],[],[],[]]
输出：[6,3,4,1,5,2,0,7]
示例 2：

输入：n = 8, m = 2, group = [-1,-1,1,0,0,1,0,-1], beforeItems = [[],[6],[5],[6],[3],[],[4],[]]
输出：[]
解释：与示例 1 大致相同，但是在排序后的列表中，4 必须放在 6 的前面。
```



```java
提示：

1 <= m <= n <= 3 * 104
group.length == beforeItems.length == n
-1 <= group[i] <= m - 1
0 <= beforeItems[i].length <= n - 1
0 <= beforeItems[i][j] <= n - 1
i != beforeItems[i][j]
beforeItems[i] 不含重复元素
```


链接：https://leetcode-cn.com/problems/sort-items-by-groups-respecting-dependencies

## 解题记录

+ 通过拓扑排序进行排序处理
+ 通过需要分别对组和项目进行拓扑排序， 得到组的顺序，以及项目的顺序
+ 然后通过组的获取组内项目的顺序
+ 最终获取结果



```java
/**
 * @author: ffzs
 * @Date: 2021/1/12 下午7:56
 */
public class Solution {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int len = group.length;
        for (int i = 0; i < group.length; i++) if (group[i] == -1) group[i] = m++;

        List<Integer>[] groupGraph = new ArrayList[m];
        int[] groupIdg = new int[m];
        for (int i = 0; i < m; i++) groupGraph[i] = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int gId = group[i];
            List<Integer> before = beforeItems.get(i);
            for (int bId : before) {
                if (group[bId] != gId) {
                    groupGraph[group[bId]].add(gId);
                    groupIdg[gId]++;
                }
            }
        }

        List<Integer>[] itemGraph = new ArrayList[n];
        int[] itemIdg = new int[n];
        for (int i = 0; i < len; i++) itemGraph[i] = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j : beforeItems.get(i)) {
                itemGraph[j].add(i);
                itemIdg[i]++;
            }
        }


        List<Integer> groupRank = topologicalSort(groupGraph, groupIdg, m);

        if (groupRank.size() == 0) return new int[0];

        List<Integer> itemRank = topologicalSort(itemGraph, itemIdg, n);
        if (itemRank.size() == 0) return new int[0];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i : itemRank) {
            int gId= group[i];
            if (!map.containsKey(gId)) map.put(gId, new ArrayList<>());
            map.get(gId).add(i);
        }

        int[] res = new int[n];
        int i = 0;
        for (int gId : groupRank) {
            if (map.containsKey(gId)) {
                for (int id : map.get(gId)) {
                    res[i++] = id;
                }
            }
        }

        return res;
    }

    private List<Integer> topologicalSort(List<Integer>[] graph, int[] idg, int n) {
        List<Integer> ret = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) if (idg[i] == 0) queue.offer(i);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            ret.add(cur);
            for (int i : graph[cur]) {
                idg[i] --;
                if (idg[i] == 0) queue.offer(i);
            }
        }

        return ret.size() == n? ret: new ArrayList<>();
    }
}
```

![image-20210112211639983](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210112211639983.png)