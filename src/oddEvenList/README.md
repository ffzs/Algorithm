## [328. 奇偶链表](https://leetcode-cn.com/problems/odd-even-linked-list/)

## 题目

给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

示例 1:

输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
示例 2:

输入: 2->1->3->5->6->4->7->NULL 
输出: 2->3->6->7->1->5->4->NULL
说明:

应当保持奇数节点和偶数节点的相对顺序。
链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。


链接：https://leetcode-cn.com/problems/odd-even-linked-list

## 解题记录

+ 就是交换节点的问题
+ 跟踪一个奇数pre节点，和一个偶数pre节点，一个偶数头节点，交替更改指向
+ 偶数的pre为null或是next为null跳出循环

```java
/**
 * @author: ffzs
 * @Date: 2020/11/13 下午9:58
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = head, evenHead = head.next, head2 = head.next;
        while (evenHead!=null && evenHead.next != null) {
            oddHead.next = evenHead.next;
            oddHead = oddHead.next;
            ListNode next = oddHead.next;
            oddHead.next = head2;
            evenHead.next = next;
            evenHead = evenHead.next;
        }
        return head;
    }
}
```

![image-20201113225523912](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201113225523912.png)