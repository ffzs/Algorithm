## [86. 分隔链表](https://leetcode-cn.com/problems/partition-list/)

## 题目

给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

 

```java
示例：

输入：head = 1->4->3->2->5->2, x = 3
输出：1->2->2->4->3->5
```


链接：https://leetcode-cn.com/problems/partition-list

## 解题记录

+ 通过新建两个链表直接将原链表分开
+ 之后再合并即可

```java
/**
 * @author: ffzs
 * @Date: 2021/1/3 上午10:18
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode l1Head = new ListNode(-1);
        ListNode l1tail = l1Head;
        ListNode l2Head = new ListNode(-1);
        ListNode l2tail = l2Head;
        while (head != null) {
            if (head.val < x) {
                l1tail.next = new ListNode(head.val);
                l1tail = l1tail.next;
            }
            else {
                l2tail.next = new ListNode(head.val);
                l2tail = l2tail.next;
            }
            head = head.next;
        }
        l1tail.next = l2Head.next;
        return l1Head.next;
    }
}
```

![image-20210103103718884](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210103103718884.png)