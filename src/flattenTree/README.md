## [114. 二叉树展开为链表](https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/)

## 题目

给定一个二叉树，原地将它展开为一个单链表。

 

例如，给定二叉树

```java
    1
   / \
  2   5
 / \   \
3   4   6
```

将其展开为：

```java
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```


链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list

## 解题记录

+ 通过前序遍历得到节点顺序
+ 在根据节点顺序构建链表

```java
/**
 * @author: ffzs
 * @Date: 2020/8/2 上午10:06
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
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        flatten(root, list);
        for (int i = 1; i < list.size(); ++i) {
            TreeNode pre = list.get(i-1);
            pre.left = null;
            pre.right = list.get(i);
        }

    }

    private void flatten(TreeNode root, List<TreeNode> list) {
        if(root != null) {
            list.add(root);
            flatten(root.left, list);
            flatten(root.right, list);
        }
    }
}

```

![image-20200802102001297](README.assets/image-20200802102001297.png)

+ 仔细观察一下，只要同级的树将右叶接到左叶的下面，就能够得到要求的单链表

```java
/**
 * @author: ffzs
 * @Date: 2020/8/2 上午10:23
 */
public class Solution2 {
    public void flatten(TreeNode root) {
        if (root != null) {

            flatten(root.left);
            flatten(root.right);

            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;

            while (root.right != null)  root = root.right;

            root.right = tmp;
        }
    }
}
```

![image-20200802102747097](README.assets/image-20200802102747097.png)