## 897. 递增顺序搜索树

## 题目

给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。

```java
示例 1：


输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
示例 2：

输入：root = [5,1,7]
输出：[1,null,5,null,7]
```

```java
提示：

树中节点数的取值范围是 [1, 100]
0 <= Node.val <= 1000
```


链接：https://leetcode-cn.com/problems/increasing-order-search-tree

## 解题记录

+ 优先通过中序遍历获取顺序的所有顺序节点，然后将这些节点按照新的顺序写到新的树中

```java
/**
 * @author: ffzs
 * @Date: 2021/4/25 上午10:05
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
    TreeNode node = null;
    TreeNode res = null;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs (TreeNode root) {
        if (root == null) return;

        dfs(root.left);

        if (node == null) {
            node = root;
            res = node;
        }
        else {
            node.right = root;
            node.left = null;
            node = node.right;
        }

        dfs(root.right);
    }

}
```

![image-20210425122726669](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210425122726669.png)