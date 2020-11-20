## [147. 对链表进行插入排序](https://leetcode-cn.com/problems/insertion-sort-list/)

## 题目

对链表进行插入排序。

插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。 

插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。

```java
示例 1：

输入: 4->2->1->3
输出: 1->2->3->4
示例 2：

输入: -1->5->3->4->0
输出: -1->0->3->4->5
```


链接：https://leetcode-cn.com/problems/insertion-sort-list



## 解题记录

+ 首先通过比较大小，找到链表中非正常顺序的节点
+ 然后编写一个函数从头到尾遍历链表找到插入位点，插入即可

```java
/**
 * @author: ffzs
 * @Date: 2020/11/20 上午11:28
 */


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode root = new ListNode(Integer.MIN_VALUE);
        root.next = head;
        while (head.next != null) {
            if (head.next.val < head.val) {
                ListNode next = head.next;
                head.next = next.next;
                insert(root, next);
            }
            else head = head.next;
        }
        return root.next;
    }

    private void insert (ListNode head, ListNode cur) {
        while (head.next != null && head.next.val < cur.val) {
            head = head.next;
        }
        cur.next = head.next;
        head.next = cur;
    }
}
```

![image-20201120121056096](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201120121056096.png)