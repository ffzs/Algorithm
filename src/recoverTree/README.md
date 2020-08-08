## [99. 恢复二叉搜索树](https://leetcode-cn.com/problems/recover-binary-search-tree/)

## 题目

二叉搜索树中的两个节点被错误地交换。

请在不改变其结构的情况下，恢复这棵树。

```java
示例 1:

输入: [1,3,null,null,2]

   1
  /
 3
  \
   2

输出: [3,1,null,null,2]

   3
  /
 1
  \
   2
```

```java
示例 2:

输入: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

输出: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
```

```java
进阶:

使用 O(n) 空间复杂度的解法很容易实现。
你能想出一个只使用常数空间的解决方案吗？
```


链接：https://leetcode-cn.com/problems/recover-binary-search-tree

## 解题记录

+ 应为是二叉搜索树，中序便利是递增的
+ 为了不改变树的结构，优先中序便利二叉树，获得中序遍历顺序的数据
+ 由于有两个位置错了，那么得到的数据自然不是递增的
+ 将数组sort，得到递增数据
+ 通过中序遍历，比对数据不对的更换即可

```java
/**
 * @author: ffzs
 * @Date: 2020/8/8 上午8:26
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

    List<Integer> values;
    int index = 0;
    public void recoverTree(TreeNode root) {
        values = new ArrayList<>();
        getValue(root);
        values.sort(Comparator.naturalOrder());
        changeValue(root);
    }

    private void getValue (TreeNode root) {
        if (root != null) {
            getValue(root.left);
            values.add(root.val);
            getValue(root.right);
        }
    }

    private void changeValue (TreeNode root) {
        if (root != null) {
            changeValue(root.left);
            if (root.val != values.get(index)){
                root.val = values.get(index);
            }
            index ++;
            changeValue(root.right);
        }
    }
}

```

![image-20200808091551334](README.assets/image-20200808091551334.png)

## 进阶

+ 题目说只有两个节点发生了变化
+ 那么可知在中序遍历的情况下，有一个节点比后一个节点大，而且有一个节点比前一个节点小，因为就是这两个节点的位置发生了变化
+ 那么我们只需要将这两个节点找到，并且更换他们的value即可达到目的

```java
/**
 * @author: ffzs
 * @Date: 2020/8/8 上午8:59
 */
public class Solution2 {

    TreeNode wrong1 = null;
    TreeNode wrong2 = null;
    TreeNode preNode = null;
    public void recoverTree(TreeNode root) {
        sortTree(root);

        int tmp = wrong1.val;
        wrong1.val = wrong2.val;
        wrong2.val = tmp;
    }

    private void sortTree (TreeNode root) {
        if (root != null) {
            sortTree(root.left);

            if (preNode == null) preNode = root;
            if (wrong1 == null && root.val < preNode.val) wrong1 = preNode;
            if (wrong1 != null && root.val < preNode.val) wrong2 = root;
            preNode = root;

            sortTree(root.right);
        }
    }
}
```

![image-20200808091522969](README.assets/image-20200808091522969.png)