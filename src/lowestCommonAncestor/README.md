## [235. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)

## 题目

给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

```java
示例 1:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
```



```java
示例 2:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
```

```java
说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉搜索树中。
```


链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree

## 解题记录

+ 后续遍历，通过比对传递节点，最终将共同父节点传递到根节点

```java
public class lowestCommonAncestor {
    public static TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        else if (root==p||root==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (right == null && left == null) return null;
        else if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}
```

![image-20200927073259203](README.assets/image-20200927073259203.png)

## 简化

+ 因为本题是二叉搜索树，因为二叉搜索树的特性，只需要比较大小就能判断递归方向，找到结果

```java
/**
 * @author: ffzs
 * @Date: 2020/9/27 上午7:07
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        // 如果pq的都小于val，说明在左边
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // 如果pq的值都大于val，说明共同父节点在右边
        else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // 如果p，q一个大于一个小于，说明，该节点就是共同父节点
        else {
            return root;
        }
    }
}
```

![image-20200927073528127](README.assets/image-20200927073528127.png)