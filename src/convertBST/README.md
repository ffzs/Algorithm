## [538. 把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)

## 题目

给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。



```java
例如：

输入: 原始二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13
```


链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree

## 解题记录

+ 因为二叉搜索树的特性是中序遍历依次递增
+ 我们只要反向中序遍历，进行累加即可

```java
/**
 * @author: ffzs
 * @Date: 2020/9/21 上午7:06
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        greater(root);
        return root;
    }

    private void greater (TreeNode root) {
        if (root != null) {
            greater(root.right);
            sum += root.val;
            root.val = sum;
            greater(root.left);
        }
    }
}
```

![image-20200921071534159](README.assets/image-20200921071534159.png)

