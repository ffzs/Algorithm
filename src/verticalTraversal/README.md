## 987. 二叉树的垂序遍历

## 题目

给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。

对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。

二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。

返回二叉树的 垂序遍历 序列。

```java
示例 1：


输入：root = [3,9,20,null,null,15,7]
输出：[[9],[3,15],[20],[7]]
解释：
列 -1 ：只有结点 9 在此列中。
列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
列  1 ：只有结点 20 在此列中。
列  2 ：只有结点 7 在此列中。
示例 2：


输入：root = [1,2,3,4,5,6,7]
输出：[[4],[2],[1,5,6],[3],[7]]
解释：
列 -2 ：只有结点 4 在此列中。
列 -1 ：只有结点 2 在此列中。
列  0 ：结点 1 、5 和 6 都在此列中。
          1 在上面，所以它出现在前面。
          5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
列  1 ：只有结点 3 在此列中。
列  2 ：只有结点 7 在此列中。
示例 3：

输入：root = [1,2,3,4,6,5,7]
输出：[[4],[2],[1,5,6],[3],[7]]
解释：
这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。
```

```java
提示：

树中结点数目总数在范围 [1, 1000] 内
0 <= Node.val <= 1000
```


链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree

## 解题记录

+ 通过哈希进行行列存储
+ 遍历树将行列对应的值放到list中进行存储
+ 最后通过对map的key进行排序，将val写入list即可

```java
/**
 * @author: ffzs
 * @Date: 2021/7/31 上午6:52
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    Map<Integer, Map<Integer, List<Integer>>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new HashMap<>();
        dfs(root,0,0);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cols = getSortKey(map.keySet());
        for (int col : cols) {
            List<Integer> lst = new ArrayList<>();
            var subMap = map.get(col);
            var rows = getSortKey(subMap.keySet());
            for (int row : rows) {
                var tmp = subMap.get(row);
                tmp.sort(Comparator.naturalOrder());
                lst.addAll(tmp);
            }
            res.add(lst);
        }
        return res;
    }

    private List<Integer> getSortKey(Set<Integer> keySet){
        List<Integer> keys = new ArrayList<>(keySet);
        keys.sort(Comparator.naturalOrder());
        return keys;
    }

    private void dfs(TreeNode node, int col, int row) {
        if (node == null) return;

        Map<Integer, List<Integer>> subMap = map.getOrDefault(col, new HashMap<>());
        if (!subMap.containsKey(row)) subMap.put(row, new ArrayList<>());
        subMap.get(row).add(node.val);
        map.put(col, subMap);
        dfs(node.left, col - 1, row + 1);
        dfs(node.right, col + 1, row + 1);
    }
}
```

![image-20210731074446495](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210731074446495.png)