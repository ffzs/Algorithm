## [530. 二叉搜索树的最小绝对差](https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/)

## 题目

给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。

 

```java
示例：

输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
```


链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst

## 解题记录

+ 因为是搜索树，而且求的事最小差值，那么只需要中序遍历过程中记录上一个值，然后进行比较即可

```java
/**
 * @author: ffzs
 * @Date: 2020/10/12 上午6:23
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    int pre = -1, min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs (TreeNode root) {
        if (root != null) {
            dfs(root.left);

            if (pre>=0) min = Math.min(root.val - pre, min);
            pre = root.val;

            dfs(root.right);
        }
    }
}
```

![image-20201012063145125](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201012063145125.png)