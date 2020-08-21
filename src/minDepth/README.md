# 111. 二叉树的最小深度
## 题目

给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。
```java
示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.
```


链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree

## 解题记录
+ 通过后序遍历遍历树
+ 每一层区分对待单侧子树的情况
```java
/**
 * @author: ffzs
 * @Date: 2020/8/21 上午7:43
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int minDepth(TreeNode root) {

        return dfs(root, 1);
    }

    public int dfs (TreeNode root, int level) {
        if (root == null) return level-1;
        if (root.left == null && root.right == null)
            return level;
        else if (root.left == null)
            return dfs(root.right, level+1);
        else if (root.right == null)
            return dfs(root.left, level+1);
        else
            return Math.min(dfs(root.left, level+1), dfs(root.right, level+1));
    }
}
```

![image-20200821080700587](README.assets/image-20200821080700587.png)

+ 简化版

```java
/**
 * @author: ffzs
 * @Date: 2020/8/21 上午8:07
 */
public class Solution2 {

    public int minDepth(TreeNode root) {
        return dfs(root, 1);
    }

    private int dfs (TreeNode root, int level) {
        if (root == null) return level -1;

        int left = dfs(root.left, level+1);
        int right = dfs(root.right, level+1);

        int min = Math.min(left, right);
        return min == level?Math.max(left, right):min;
    }
}
```

![image-20200821081124034](README.assets/image-20200821081124034.png)