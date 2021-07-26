## 671. 二叉树中第二小的节点

## 题目

给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。

更正式地说，root.val = min(root.left.val, root.right.val) 总成立。

给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

```java
示例 1：


输入：root = [2,2,5,null,null,5,7]
输出：5
解释：最小的值是 2 ，第二小的值是 5 。
示例 2：

输入：root = [2,2,2]
输出：-1
解释：最小的值是 2, 但是不存在第二小的值。
```

```java
提示：

树中节点数目在范围 [1, 25] 内
1 <= Node.val <= 231 - 1
对于树中每个节点 root.val == min(root.left.val, root.right.val)
```


链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree

## 解题记录

+ 通过遍历树，找打第二小的值即可
+ 这里遍历注意第二小只能出现在和最小相同子树下

```java
/**
 * @author: ffzs
 * @Date: 2021/7/27 上午7:09
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
    private int res = -1;
    private int min;
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root.left == null) return;
        if (root.left.val == min) {
            if (root.right.val != min) {
                res = res == -1 ? root.right.val:Math.min(res, root.right.val);
            }
            dfs(root.left);
        }
        if (root.right.val == min) {
            if (root.left.val != min) res = res == -1 ? root.left.val:Math.min(res, root.left.val);
            dfs(root.right);
        }
    }
}
```



![image-20210727073750590](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210727073750590.png)