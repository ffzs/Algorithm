## [435. 无重叠区间](https://leetcode-cn.com/problems/non-overlapping-intervals/)

## 题目

给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。

```java
示例 1:
输入: [ [1,2], [2,3], [3,4], [1,3] ]
输出: 1
解释: 移除 [1,3] 后，剩下的区间没有重叠。
    
示例 2:
输入: [ [1,2], [1,2], [1,2] ]
输出: 2
解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
    
示例 3:
输入: [ [1,2], [2,3] ]
输出: 0
解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
```


链接：https://leetcode-cn.com/problems/non-overlapping-intervals

## 解题记录

+ 通过贪心算法求解
+ 要想删除的少的话，那么就在删除的时候删掉覆盖大的
+ 可以优先将区间进行排序
+ 然后两两比较区间如果不重合的话直接比较下一对
+ 重合的话需要删除右边界较大的那个

```java
/**
 * @author: ffzs
 * @Date: 2020/12/31 上午8:10
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        int res = 0, i = 0;
        for (int j = 1; j < n; j++) {
            if (intervals[i][1] > intervals[j][0]) {
                res ++;
                i = intervals[i][1] < intervals[j][1] ? i : j;
            }
            else i = j;
        }
        return res;
    }
}

class Test{
    public static void main(String[] args) {
        int[][] intervals = {{0,2},{1,3},{2,4},{3,5},{4,6}};
        Solution solution = new Solution();
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
}
```

![image-20201231085519320](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201231085519320.png)