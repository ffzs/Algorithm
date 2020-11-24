## [222. 完全二叉树的节点个数](https://leetcode-cn.com/problems/count-complete-tree-nodes/)

## 题目

给出一个完全二叉树，求出该树的节点个数。

说明：

完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~$2^h$ 个节点。

```java
示例:

输入: 
    1
   / \
  2   3
 / \  /
4  5 6

输出: 6
```


链接：https://leetcode-cn.com/problems/count-complete-tree-nodes

## 解题记录

+ 通过一次获取left得到树的层数
+ 通过中序遍历获取到树最后一层的节点个数
+ 在加上其余层的$2^i$

```java
/**
 * @author: ffzs
 * @Date: 2020/11/24 上午7:44
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int max = 0, res = 0;
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode tmp = root;
        while (tmp != null) {
            max++;
            tmp = tmp.left;
        }
        System.out.println(max);
        dfs(root, 1);
        for (int i = 0; i < max-1; i++) {
            res += Math.pow(2, i);
        }
        return res;
    }

    private void dfs (TreeNode root, int level) {
        if (level == max) res++;
        if(root.left!=null) dfs(root.left, level+1);
        if(root.right!=null) dfs(root.right, level+1);
    }
}
```

![image-20201124081108884](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201124081108884.png)