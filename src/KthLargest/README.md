## [703. 数据流中的第 K 大元素](https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/)

## 题目

设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。

请实现 KthLargest 类：

+ KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
+ int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。

```java
示例：

输入：
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
输出：
[null, 4, 5, 5, 8, 8]

解释：
KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
kthLargest.add(3);   // return 4
kthLargest.add(5);   // return 5
kthLargest.add(10);  // return 5
kthLargest.add(9);   // return 8
kthLargest.add(4);   // return 8
```

```java
提示：
1 <= k <= 104
0 <= nums.length <= 104
-104 <= nums[i] <= 104
-104 <= val <= 104
最多调用 add 方法 104 次
题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
```


链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream

## 解题记录

+ 通过堆维护一个k大小的集合，如果大于就加入将较小的弹出
+ 每回add的时候返回最top的值即可
+ 要注意初始数组为空等情况

```java
/**
 * @author: ffzs
 * @Date: 2021/2/11 上午8:47
 */
public class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(Comparator.naturalOrder());
        if (nums.length > 0) {
            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= Math.max(nums.length - k, 0); i--) {
                pq.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (pq.size() == 0 || pq.size() < k) {
            pq.offer(val);
        }
        else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
```

![image-20210211091452046](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210211091452046.png)