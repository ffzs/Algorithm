## [83. 删除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/)

## 题目

存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。

返回同样按升序排列的结果链表。

```java
示例 1：
输入：head = [1,1,2]
输出：[1,2]

示例 2：
输入：head = [1,1,2,3,3]
输出：[1,2,3]
```



```java
提示：
链表中节点数目在范围 [0, 300] 内
-100 <= Node.val <= 100
题目数据保证链表已经按升序排列
```


链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list

## 解题记录

+ 因为是有序的链表，直接通过两两对比，然后跳过那些重复的节点即可

```java
/**
 * @author: ffzs
 * @Date: 2021/3/26 上午9:53
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        while (pre != null) {
            while (pre.next != null && pre.val == pre.next.val) {
                pre.next = pre.next.next;
            }
            pre = pre.next;
        }
        return head;
    }

}
```

![image-20210326101747891](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210326101747891.png)