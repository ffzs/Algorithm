## [19. 删除链表的倒数第N个节点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/)

## 题目

给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

```java
示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。
```

进阶：

你能尝试使用一趟扫描实现吗？




链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list

## 解题记录

+ 要求使用以便扫描，那么只能使用递归进行处理，并且通过n计数，当n为0的时候进行删除
+ 有一点要注意就是删除头节点

```java
/**
 * @author: ffzs
 * @Date: 2020/10/18 上午9:18
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    int n;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        this.n = n;
        remove(head);

        return this.n == 0 ? head.next: head;
    }

    private void remove (ListNode node) {
        if (node != null) {
            remove(node.next);

            if (n-- == 0) {
                node.next = node.next.next;
            }
        }
    }
}
```

![image-20201018104213534](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201018104213534.png)