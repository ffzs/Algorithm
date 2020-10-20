## [143. 重排链表](https://leetcode-cn.com/problems/reorder-list/)

## 题目

给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

```java
示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
```

```java
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
```


链接：https://leetcode-cn.com/problems/reorder-list

## 解题记录

+ 通过递归获取从后向前的访问链表
+ 通过重新指定next完成拼接
+ 为了不出现环，尾部的node去掉之后指定next为null

```java
/**
 * @author: ffzs
 * @Date: 2020/10/20 上午6:55
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {

    ListNode left;
    public void reorderList(ListNode head) {
        left = head;
        reorder(head);
    }

    private void reorder (ListNode node) {
        if (node!=null && node.next != null) {
            reorder(node.next);
            if (left.next == null || left.next.next == null ) return;
            ListNode cur = node.next;
            node.next = null;
            cur.next = left.next;
            left.next = cur;
            left = cur.next;
        }
    }
}
```

![image-20201020090140121](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201020090140121.png)