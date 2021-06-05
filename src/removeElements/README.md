## 203. 移除链表元素

## 题目

给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。

```java
示例 1：


输入：head = [1,2,6,3,4,5,6], val = 6
输出：[1,2,3,4,5]
示例 2：

输入：head = [], val = 1
输出：[]
示例 3：

输入：head = [7,7,7,7], val = 7
输出：[]
```



```java
提示：

列表中的节点在范围 [0, 104] 内
1 <= Node.val <= 50
0 <= k <= 50
```


链接：https://leetcode-cn.com/problems/remove-linked-list-elements

## 解题记录

+ 没啥可说的，就是出现值一样的节点的话直接pre的next执行下一个即可,就是从链表中删除
+ 为了防止头结点就是目标删除节点，这里在链表之前加一个新的头结点

```java
/**
 * @author: ffzs
 * @Date: 2021/6/5 上午9:05
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode pre = root;
        while (head != null) {
            if (head.val == val) {
                pre.next=head.next;
            }
            else pre = pre.next;
            head = head.next;
        }
        return root.next;
    }

}
```

![image-20210605122532128](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210605122532128.png)