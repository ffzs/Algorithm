## [109. 有序链表转换二叉搜索树](https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/)

## 题目

给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

```java
示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
```


链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree

## 解题记录

+ 先层序遍历完成树结构
+ 再中序遍历填值

```java
/**
 * @author: ffzs
 * @Date: 2020/8/18 上午8:39
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


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

    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        TreeNode root = new TreeNode(head.val);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        ListNode cur = head.next;
        marker: while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = queue.poll();
                if (cur != null) {
                    assert tn != null;
                    tn.left = new TreeNode(cur.val);
                    queue.add(tn.left);
                    cur = cur.next;
                }
                else break marker;
                if (cur != null) {
                    tn.right = new TreeNode(cur.val);
                    queue.add(tn.right);
                    cur = cur.next;
                }
            }
        }
        node = head;
        sortedListToBST(root);
        return root;
    }

    private void sortedListToBST (TreeNode root) {
        if (root != null) {
            sortedListToBST(root.left);
            root.val = node.val;
            node = node.next;
            sortedListToBST(root.right);
        }
    }
}
```

![image-20200818091756096](README.assets/image-20200818091756096.png)

效果不理想，可以考虑将链表中数据提取为List之后通过二分法处理，没一轮将mid写入到tree节点，递归left，right， left大于right返回。

在不转化为list时也可使用这个方法，就是使用快慢指针，通过快慢指针在链表中定位到中间值

## 快慢指针

+ 快指针是慢指针速度的二倍
+ 快指针遍历完成时，慢指针正好为中间位置

```java
/**
 * @author: ffzs
 * @Date: 2020/8/18 上午9:27
 */
public class Solution2 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;  // 通过设置pre对链表进行切割
        while(fast!= null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode node = slow.next;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(node);
        return root;
    }
}
```

![image-20200818094522724](README.assets/image-20200818094522724.png)