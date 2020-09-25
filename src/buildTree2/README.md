## [106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

## 题目

根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

```java
例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
```


链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

## 解题记录

+ 因为没有重复序列，鉴于中序遍历父节点的位置正好将左右两树分开，通过map记录下中序遍历中节点值和index的映射关系
+ 后续遍历从后向前的顺序是，父->右->左
+ 通过后续遍历逆向或取节点，最后一个一定是根节点，通过map获取到根节点的位置，通过根节点位置分割，根节点左边就是左树，根节点右边就是右树
+ 以此递归下去获取全树

```java
/**
 * @author: ffzs
 * @Date: 2020/9/25 上午7:23
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    int[] inorder;
    int[] postorder;
    int index;
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.index = postorder.length-1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, postorder.length-1);
    }

    private TreeNode buildTree (int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(postorder[index]);
        int cur = map.get(postorder[index]);
        index--;
        root.right = buildTree(cur+1, end);
        root.left = buildTree(start, cur-1);
        return root;
    }
}
```

![image-20200925074949981](README.assets/image-20200925074949981.png)

## 进阶

+ 同样通过切分中序遍历数组，区分左树右树
+ 这里如果左树和右树的值正好是区间的边界，那么意味着他没有子树，因此返回null
+ 通过中序遍历逆推来判断边界

```java
int pi;
int ii;
public TreeNode buildTree(int[] inorder, int[] postorder) {
    pi = postorder.length-1;
    ii = inorder.length-1;
    return buildTree(inorder, postorder, Integer.MAX_VALUE);
}

private TreeNode buildTree (int[] inorder, int[] postorder, int mid) {
    if (pi < 0) return null;
    if (inorder[ii] == mid) {
        ii --;
        return null;
    }

    int cur = postorder[pi];
    TreeNode root = new TreeNode(cur);
    pi--;

    root.right = buildTree(inorder, postorder, cur);
    root.left = buildTree(inorder, postorder, mid);
    return root;
}
```

![image-20200925082232036](README.assets/image-20200925082232036.png)