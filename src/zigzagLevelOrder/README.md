## [103. 二叉树的锯齿形层序遍历](https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/)

## 题目

给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

```java
例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层序遍历如下：

[
  [3],
  [20,9],
  [15,7]
]
```


链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal

## 解题记录

+ 层序遍历，奇偶行写入一个在后面加入，一个在前面

```java
/**
 * @author: ffzs
 * @Date: 2020/12/22 下午7:54
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new LinkedList<>();
        int level = 0;
        deque.add(root);
        while (!deque.isEmpty()) {
            int num = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                TreeNode cur = deque.pop();
                System.out.println(cur.val);
                if ((level&1) == 0) list.add(cur.val);
                else list.add(0, cur.val);
                if (cur.left != null) deque.offer(cur.left);
                if (cur.right != null) deque.offer(cur.right);
            }
            res.add(list);
            level++;
        }
        return res;
    }
}
```

![image-20201222201838658](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201222201838658.png)