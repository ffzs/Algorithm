---
typora-copy-images-to: ./
---

## [24. 两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/)

## 题目

给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.


链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs

## 解题记录

+ 单向链表中交换两个节点n1,n2，需要n1的前一个节点pre（head除外），以n2的后一个节点cur
+ 通过pre->n2->n1->cur进行修改即可

```java
/**
 * @author: ffzs
 * @Date: 2020/10/13 上午7:15
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = head.next;

        ListNode n1, n2, cur = head, pre = null;

        while (cur != null && cur.next != null) {
            n1 = cur;
            n2 = n1.next;
            cur = n2.next;
            if (pre != null) pre.next = n2;
            n2.next = n1;
            n1.next = cur;
            pre = n1;
        }

        return res;
    }
}
```

![image-20201013074038798](README.assets/image-20201013074038798.png)