## [面试题 02.01. 移除重复节点](https://leetcode-cn.com/problems/remove-duplicate-node-lcci/)



## 题目

编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

```
示例1:

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
```

```
示例2:

 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
```

```
提示：

链表长度在[0, 20000]范围内。
链表元素在[0, 20000]范围内。
```

```
进阶：

如果不得使用临时缓冲区，该怎么解决？
```


链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci

## 解题记录

+ 通过set记录出现过的值，重复的跳过

```java
import java.util.HashSet;
import java.util.Set;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/26
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        ListNode tmp = head;
        Set<Integer> valSet = new HashSet<>();
        valSet.add(tmp.val);
        while (tmp.next!= null) {
            if (valSet.contains(tmp.next.val)) {
                tmp.next = tmp.next.next ;
            }else{
                valSet.add(tmp.next.val);
                tmp = tmp.next;
            }
        }

        return head;
    }
}

```

![image-20200626100915287](README.assets/image-20200626100915287.png)

## 优化

+ 因为本题限定了数取值的大小，可以构建一个定长数组`new boolean[20001]`来存储数值的出现情况，这样避免了使用set包装器转换带来的消耗

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/6/26
 */
public class Solution2 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        ListNode tmp = head;
        boolean[] valList = new boolean[20001];
        valList[head.val] = true;
        while (tmp.next!= null) {
            if (valList[tmp.next.val]) {
                tmp.next = tmp.next.next ;
            }else{
                valList[tmp.next.val] = true;
                tmp = tmp.next;
            }
        }
        return head;
    }
}
```

![image-20200626101216711](README.assets/image-20200626101216711.png)

## 进阶

+ 要不使用缓存的话就不能使用set,list这些存储节点
+ 有个思路是，通过冒泡排序的方法，一边对比排序一边去掉重复的值，但是头结点不能变，是不是不能改变出现顺序
+ 还有一个方法就是通过遍历该节点之后的节点，有重复的直接去掉，不过速度很慢就是了，节省了空间



```java
/**
 * @author ffzs
 * @describe
 * @date 2020/6/26
 */
public class Solution3 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) return null;
        ListNode tmp = head;
        while (tmp != null) {
            ListNode t = tmp;
            while (t.next != null) {
                if (t.next.val == tmp.val) {
                    t.next = t.next.next;
                }
                else {
                    t = t.next;
                }
            }
            tmp = tmp.next;
        }
        return head;
    }
}
```

![image-20200626102416406](README.assets/image-20200626102416406.png)

+ 想了一下如果可以改变出现顺序的话，可以从head的下一个开始进行冒泡排序处理，如果该节点的值或head的值和next的值相同，直接删掉next，如果大于next值，交换位置，如果小于跳到next
+ 不过这里交换的话需要上一节点，可以使用next和next.next进行比较
+ 重复多次，知道不再发生交换，返回head

