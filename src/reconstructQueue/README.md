## [406. 根据身高重建队列](https://leetcode-cn.com/problems/queue-reconstruction-by-height/)

## 题目

假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

```java
示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
```


链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height

## 解题记录

+ 首先将数组通过身高由高到低排序
+ 因为数组的第二个元素是身高高于本身高的人数，那么写入列表的时候，可以将该数插在多少名之后，因为在插入该数之前插入的都是不小于该数的。

```java
/**
 * @author: ffzs
 * @Date: 2020/11/16 上午11:16
 */
public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> tmp = new ArrayList<>();
        for (int[] p : people) {
            tmp.add(p[1], p);
        }
        return tmp.toArray(new int[tmp.size()][]);
    }
}
```

![image-20201116140206098](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201116140206098.png)