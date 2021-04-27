## 938. 二叉搜索树的范围和

## 题目

给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。 

```java
示例 1：
输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
输出：32

示例 2：
输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
输出：23
```




```java
提示：

树中节点数目在范围 [1, 2 * 104] 内
1 <= Node.val <= 105
1 <= low <= high <= 105
所有 Node.val 互不相同
```


链接：https://leetcode-cn.com/problems/range-sum-of-bst

## 解题记录

+ 因为二叉搜索树有个特征就是父节点的左边值小于父节点值，右子树值大于父结点值
+ 因此可以通过判断父节点和范围关系，避开一些不在范围内的节点，提高查找速度



```java
/**
 * @author: ffzs
 * @Date: 2021/4/27 下午2:42
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        else if (root.val <= high && root.val >= low) return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        else if (root.val < low) return rangeSumBST(root.right, low, high);
        else return rangeSumBST(root.left, low, high);
    }

}
```

![image-20210427145821790](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210427145821790.png)