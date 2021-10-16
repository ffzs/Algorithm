## 230. 二叉搜索树中第K小的元素

## 题目

给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

 

示例 1：


输入：root = [3,1,4,null,2], k = 1
输出：1
示例 2：


输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3




提示：

树中的节点数为 n 。
1 <= k <= n <= 104
0 <= Node.val <= 104


进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？


链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst

## 解题记录

+ 因为是二叉搜索树直接通过前序遍历获取前k个值即可

```java
/**
 * @author: ffzs
 * @Date: 2021/10/17 上午7:01
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
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return dfs(root);
    }

    private int dfs(TreeNode node){
        if (node == null || k < 0) return 0;
        int left = dfs(node.left);
        k--;
        if (k == 0) return node.val;
        int right = dfs(node.right);
        return left + right;
    }

}
```

![image-20211017075615787](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211017075615787.png)