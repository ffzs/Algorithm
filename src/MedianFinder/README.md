## 295. 数据流的中位数

## 题目

中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。

```java
示例：

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
```

```java
进阶:

如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
```


链接：https://leetcode-cn.com/problems/find-median-from-data-stream

## 解题记录

+ 使用大小堆维护中间数

```java
/**
 * @author: ffzs
 * @Date: 2021/8/27 上午6:53
 */
public class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        min = new PriorityQueue<>((a, b) -> (b - a));
        max = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    }

    public void addNum(int num) {
        if (min.isEmpty() || num <= min.peek()) {
            min.offer(num);
            if (min.size() - 1 > max.size()) max.offer(min.poll());
        }
        else {
            max.offer(num);
            if (max.size() > min.size()) min.offer(max.poll());
        }
    }

    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
        return min.peek();
    }

}
```

![image-20210827072159360](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210827072159360.png)