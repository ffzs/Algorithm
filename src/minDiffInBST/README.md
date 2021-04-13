## 783. 二叉搜索树节点最小距离

## 题目

给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

```java
示例 1：


输入：root = [4,2,6,1,3]
输出：1
示例 2：


输入：root = [1,0,48,null,null,12,49]
输出：1
```

```java
提示：

树中节点数目在范围 [2, 100] 内
0 <= Node.val <= 105
```


链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes

## 解题记录

+ 直接前序遍历，通过两两相减比对求出最小值

```java
/**
 * @author: ffzs
 * @Date: 2021/4/13 上午7:50
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    private Integer pre, res;
    public int minDiffInBST(TreeNode root) {
        res = Integer.MAX_VALUE;
        dfs(root);
        return res;
    }

    private void dfs (TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        if (pre == null) pre = root.val;
        else res = Math.min(res, root.val-pre);
        pre = root.val;
        dfs(root.right);
    }
}
```

![image-20210413080413633](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210413080413633.png)