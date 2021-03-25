## [82. 删除排序链表中的重复元素 II](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/)

## 题目

给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

```java
示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3
```


链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii

## 解题记录

+ 通过设置一个新的head，然后判断后续的值是否为重复值，重复到最后
+ 将重复的部分跳过，进行连接即可

```java
/**
 * @author: ffzs
 * @Date: 2021/3/25 上午9:03
 */
public class Solution {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode root = new ListNode(-1, head);
        ListNode pre = root;
        boolean in = false;
        while (pre.next != null) {
            ListNode next = pre.next;
            while (next.next != null && next.val == next.next.val) {
                next = next.next;
                in = true;
            }
            if (in) {
                pre.next = next.next;
                in = false;
            }
            else pre = pre.next;
        }

        return root.next;
    }
}
```

![image-20210325092347609](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210325092347609.png)