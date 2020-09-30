## [701. 二叉搜索树中的插入操作](https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/)

## 题目

给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。

注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。

例如, 

给定二叉搜索树:

```java
    4
   / \
  2   7
 / \
1   3
```

和 插入的值: 5
你可以返回这个二叉搜索树:

```java
     4
   /   \
  2     7
 / \   /
1   3 5
```
或者这个树也是有效的:

```java
     5
   /   \
  2     7
 / \   
1   3
     \
      4
```

```java
提示：

给定的树上的节点数介于 0 和 10^4 之间
每个节点都有一个唯一整数值，取值范围从 0 到 10^8
-10^8 <= val <= 10^8
新值和原始二叉搜索树中的任意节点值都不同
```


链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree

## 解题记录

+ 第一种方法为获取全部数据到list，然后插入新值，然后通过二分法构造新树，比较简单就不演示了
+ 第二种方法为在原树上面改，找到第一个大于给定值得节点，分一下几种情况：
  + 该节点左树为null，那么直接把目标值设为左子叶即可
  + 如果有值得化且值小于目标值，那么将目标值设为该最深右子叶
  + 如果大于目标值，那么直接将目标值创建节点作为左树，原来的左树作为新左树的右树即可
+ 还有就是递归结束也没有找到大于的值，那么直接给到root的最右子叶
+ 还有就是root为null，那么root指定为目标值即可



```java
/**
 * @author: ffzs
 * @Date: 2020/9/30 上午7:18
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
    boolean found = false;
    int val;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        this.val = val;
        dfs(root);
        if (root == null) {
            root = new TreeNode(val);
        }
        else if (!found) {
            TreeNode cur = root;
            while (cur.right != null) cur = cur.right;
            cur.right = new TreeNode(val);
        }
        return root;
    }

    private void dfs (TreeNode root) {
        if (!found && root != null) {

            dfs(root.left);
            if (!found && root.val > val) {
                System.out.println(root.val);
                if (root.left == null) {
                    root.left = new TreeNode(val);
                }
                else if (root.left.val > val) {
                    TreeNode cur = root.left;
                    root.left = new TreeNode(val);
                    root.left.right = cur;
                }
                else {
                    TreeNode cur = root.left;
                    while (cur.right != null) cur = cur.right;
                    cur.right = new TreeNode(val);
                }
                found = true;
            }
            dfs(root.right);
        }
    }
}

class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);
        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);
        Solution solution = new Solution();
        System.out.println(solution.insertIntoBST(root, 25));
    }
}
```

![image-20200930083342666](README.assets/image-20200930083342666.png)