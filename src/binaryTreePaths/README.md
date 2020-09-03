## [257. 二叉树的所有路径](https://leetcode-cn.com/problems/binary-tree-paths/)

## 题目

给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

```java
示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
```


链接：https://leetcode-cn.com/problems/binary-tree-paths

## 解题记录

+ 通过前序遍历遍历整个树
+ 通过判断无左右子叶为终结
+ 每个过程添加`num->`,如果为总结只添加数值



```java
/**
 * @author: ffzs
 * @Date: 2020/9/4 上午7:28
 */
public class Solution {
    List<String> res  = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return  res;
    }

    private void dfs(TreeNode root, StringBuilder sb) {

        if (root != null) {
            if (root.left == null && root.right == null) {
                res.add(sb.append(root.val).toString());
                return;
            }
            sb.append(root.val).append("->");
            if (root.left!=null) dfs(root.left, new StringBuilder(sb));
            if (root.right!=null) dfs(root.right, new StringBuilder(sb));
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
```

![image-20200904074526841](README.assets/image-20200904074526841.png)