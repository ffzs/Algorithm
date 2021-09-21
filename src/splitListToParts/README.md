## 725. 分隔链表

## 题目

给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。

每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。

这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。

返回一个符合上述规则的链表的列表。

举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]

```java
示例 1：

输入: 
root = [1, 2, 3], k = 5
输出: [[1],[2],[3],[],[]]
解释:
输入输出各部分都应该是链表，而不是数组。
例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
示例 2：

输入: 
root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
解释:
输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
```



```java
提示:

root 的长度范围： [0, 1000].
输入的每个节点的大小范围：[0, 999].
k 的取值范围： [1, 50].
```


链接：https://leetcode-cn.com/problems/split-linked-list-in-parts

## 解题记录

+ 优先分配个数到k
+ 然后再一个一个组成链表

```java
/**
 * @author: ffzs
 * @Date: 2021/9/22 上午6:48
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode tmp = head;
        ListNode[] res = new ListNode[k];
        int[] cnt = new int[k];
        int i = 0;
        while (tmp != null) {
            tmp = tmp.next;
            if (i >= k) i = 0;
            cnt[i++]++;
        }
        tmp = head;
        for (int j = 0; j < cnt.length; j++) {
            ListNode cur, next = null;
            if (cnt[j] == 0) {
                cur = null;
            }
            else {
                cur = new ListNode(tmp.val);
                next = cur;
                tmp = tmp.next;
            }
            for (int l = 1; l < cnt[j]; l++) {
                next.next = new ListNode(tmp.val);
                next = next.next;
                tmp = tmp.next;
            }
            res[j] = cur;
        }
        return res;
    }

}
```

![image-20210922070837166](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210922070837166.png)