## [92. 反转链表 II](https://leetcode-cn.com/problems/reverse-linked-list-ii/)

## 题目

反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

```java
说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
```


链接：https://leetcode-cn.com/problems/reverse-linked-list-ii

## 解题记录

+ 只扫描一遍进行翻转，可以一个一个进行两两对调位置
+ 本题的问题是需要记录其实位置，终止位置
+ 还有就是需要匹配只有两个node的情况，需要接个头

```java
/**
 * @author: ffzs
 * @Date: 2021/3/18 上午7:58
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right - left < 1) return head;
        ListNode root = new ListNode(-1, head);
        ListNode pre = root, l, r, tmp, tail;
        int i = 0;
        while (i < left - 1) {
            pre = pre.next;
            i++;
        }

        l = pre.next;
        tail = l;
        pre.next = null;
        r = l.next;
        l.next = null;


        while (r != null && i < right-1) {
            tmp = r;
            r = r.next;
            tmp.next = l;
            l = tmp;
            i++;
        }

        pre.next = l;
        tail.next = r;
        return root.next;
    }

}
```

![image-20210318094518564](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210318094518564.png)