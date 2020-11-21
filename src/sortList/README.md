## [148. 排序链表](https://leetcode-cn.com/problems/sort-list/)

## 题目

给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

进阶：

你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？

```java
示例 1：


输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：


输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：

输入：head = []
输出：[]
```



提示：

链表中节点的数目在范围 [0, 5 * 104] 内
-$10^5 <= Node.val <= 10^5$


链接：https://leetcode-cn.com/problems/sort-list

## 解题记录

+ 优先将链表中的数值取出，然后通过api进行快排，然后再写入链表

```java
/**
 * @author: ffzs
 * @Date: 2020/11/21 上午10:51
 */


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode sortList(ListNode head) {
        int n = 0;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        int[] tmp = new int[n];
        int i = 0;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            tmp[i++] = cur.val;
        }
        Arrays.sort(tmp);
        i = 0;
        for(ListNode cur = head; cur != null; cur = cur.next) {
            cur.val = tmp[i++];
        }
        return head;
    }
}
```

![image-20201121110525292](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201121110525292.png)

+ 因为$10^5 <= Node.val <= 10^5$，可以通过计算排序处理

```java
/**
 * @author: ffzs
 * @Date: 2020/11/21 上午11:06
 */
public class Solution2 {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        int min = head.val, max = head.val;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (min > cur.val) min = cur.val;
            else max = Math.max(max, cur.val);
        }
        int[] counter = new int[max - min + 1];
        for (ListNode cur = head; cur != null; cur = cur.next) {
            counter[cur.val - min]++;
        }
        ListNode cur = head;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                for (int j = 0; j < counter[i]; j++) {
                    cur.val = i + min;
                    cur = cur.next;
                }
            }
        }
        return head;
    }
}
```

![image-20201121111611827](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201121111611827.png)

+ 还可已使用归并，快慢指针找中点