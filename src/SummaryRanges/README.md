## 352. 将数据流变为多个不相交区间

## 题目

 给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。

实现 SummaryRanges 类：

SummaryRanges() 使用一个空数据流初始化对象。
void addNum(int val) 向数据流中加入整数 val 。
int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。

```java
示例：

输入：
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]
输出：
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

解释：
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // 返回 [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
```



```java
提示：

0 <= val <= 104
最多调用 addNum 和 getIntervals 方法 3 * 104 次


进阶：如果存在大量合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办?
```


链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals

## 解题记录

+ 由于返回是需要顺序的，通过treemap记录每一段的前后范围
+ 考虑不同情况的返回结果即可，有需要合并的情况，有直接返回的情况，有需要前后扩充的情况

```java
/**
 * @author: ffzs
 * @Date: 2021/10/9 上午6:42
 */
public class SummaryRanges {
    TreeMap<Integer, Integer> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int val) {
        Map.Entry<Integer, Integer> interval1 = map.ceilingEntry(val + 1);
        Map.Entry<Integer, Integer> interval0 = map.floorEntry(val);

        if (interval0 != null && interval0.getKey() <= val && val<=interval0.getValue()) return;
        else {
            boolean leftAside = interval0 != null && interval0.getValue() + 1 == val;
            boolean rightAside = interval1 != null && interval1.getKey() - 1 == val;
            if (leftAside && rightAside) {
                int left = interval0.getKey(), right = interval1.getValue();
                map.remove(interval0.getKey());
                map.remove(interval1.getKey());
                map.put(left, right);
            }
            else if (leftAside) map.put(interval0.getKey(), interval0.getValue() + 1);
            else if (rightAside) {
                int right = interval1.getValue();
                map.remove(interval1.getKey());
                map.put(val, right);
            }
            else map.put(val, val);
        }
    }

    public int[][] getIntervals() {
        int size = map.size();
        int[][] res = new int[size][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int left = entry.getKey(), right = entry.getValue();
            res[index++] = new int[]{left, right};
        }
        return res;
    }
}
```

![image-20211009074004996](https://gitee.com/ffzs/picture_go/raw/master/img/image-20211009074004996.png)