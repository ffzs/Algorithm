## [129. 求根到叶子节点数字之和](https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/)

## 题目

给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。

```java
示例 1:

输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
```

```java
示例 2:

输入: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.
```


链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers

## 解题记录

+ 前序遍历过程中进行累加，知道叶节点进行汇总
+ 最后返回汇总值

```java
/**
 * @author: ffzs
 * @Date: 2020/10/29 上午8:48
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return totalSum;
    }

    private void dfs(TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            totalSum += sum*10 + node.val;
            return;
        }
        if (node.left != null) {
            dfs(node.left, sum*10 + node.val);
        }
        if (node.right != null) {
            dfs(node.right, sum*10 + node.val);
        }
    }
}
```

![image-20201029090027583](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201029090027583.png)