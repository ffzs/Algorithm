## [61. 旋转链表](https://leetcode-cn.com/problems/rotate-list/)

## 题目

给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

```java
示例 1：


输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]
示例 2：

输入：head = [0,1,2], k = 4
输出：[2,0,1]
```

```java
提示：

链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 109
```


链接：https://leetcode-cn.com/problems/rotate-list

## 解题记录

+ 可以优先求的链表的长度n和并将收尾连同称为环形链表
+ 然后尾部移动n-k，之后断开即可



```java
/**
 * @author: ffzs
 * @Date: 2021/3/27 上午8:50
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        tail.next = head;

        for (int i = 0; i < (n-k%n); i++) {
            tail = tail.next;

        }

        head = tail.next;
        tail.next = null;
        return head;
    }
}
```

![image-20210327091313944](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210327091313944.png)