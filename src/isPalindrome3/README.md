## [234. 回文链表](https://leetcode-cn.com/problems/palindrome-linked-list/)

## 题目

请判断一个链表是否为回文链表。

```java
示例 1:

输入: 1->2
输出: false
```

```java
示例 2:

输入: 1->2->2->1
输出: true
```

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

链接：https://leetcode-cn.com/problems/palindrome-linked-list



## 解题记录

+ 由于要用 O(n) 时间复杂度和 O(1) 空间复杂度解决问题，那么链表只能遍历一次
+ 一边通过递归获取到链表的尾部，一边重头开始进行比较，如果都相同的话那么就是回文

```java
/**
 * @author: ffzs
 * @Date: 2020/10/23 上午9:59
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {
    ListNode pre;
    boolean res = true;
    public boolean isPalindrome(ListNode head) {
        pre = head;
        deal(head);
        return res;
    }

    private void deal (ListNode node) {
        if (node != null) {
            deal(node.next);
            if (res) {
                res = pre.val == node.val;
                pre = pre.next;
            }
        }
    }
}
```

![image-20201023102424200](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201023102424200.png)