## [104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)

## 题目

给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

```
    3
   / \
  9  20
    /  \
   15   7
```

返回它的最大深度 3 。


链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree

## 解题记录

+ 通过递归便利，记录层数，最终返回层数的最大值

```java
/**
 * @author: ffzs
 * @Date: 2020/7/28 上午8:26
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }


    public int maxDepth(TreeNode root, int level) {
        if (root == null) return level;
        int right = maxDepth(root.right, level+1);
        int left = maxDepth(root.left, level+1);
        return Math.max(level + 1, Math.max(right, left));
    }
}

```

![image-20200728083637763](README.assets/image-20200728083637763.png)