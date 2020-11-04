## [57. 插入区间](https://leetcode-cn.com/problems/insert-interval/)

## 题目

给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

 

```java
示例 1：

输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]
示例 2：

输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
```


注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。

链接：https://leetcode-cn.com/problems/insert-interval



## 解题记录

+ 观察数组情况，插入边界有几种情况，左右不沾，单边沾，都沾，包含
+ 可以通过遍历一边原始数组，构建出新的插入数组的新范围
+ 之后需要考虑的是插入数组的方法，插入过程中，在新数组范围内部的需要直接跳过
+ 需要考虑插入数组在头和尾的情况

```java
/**
 * @author: ffzs
 * @Date: 2020/11/4 上午9:58
 */
public class Solution2 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};

        for (int[] interval : intervals) {
            if (newInterval[0]>=interval[0] && newInterval[0] <= interval[1]) newInterval[0] = interval[0];
            if (newInterval[1]>=interval[0] && newInterval[1] <= interval[1]) newInterval[1] = interval[1];
        }

        int[][] res = new int[intervals.length+1][2];
        int i = 0;
        boolean flag = false;
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                res[i++] = interval;
            }
            else if (!flag && (i == 0 || res[i-1] != newInterval)) {
                res[i++] = newInterval;
                flag = true;
            }
            if (interval[0] > newInterval[1]) {
                res[i++] = interval;
            }
        }

        if (!flag) res[i++] = newInterval;
        res = Arrays.copyOf(res, i);

        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1,5}};
        int[] newInterval = {0,0};
        System.out.println(Arrays.deepToString(solution.insert(intervals, newInterval)));
    }
}
```

![image-20201104101620068](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201104101620068.png)