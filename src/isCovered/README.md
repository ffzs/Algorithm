## 1893. 检查是否区域内所有整数都被覆盖

## 题目

给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。

如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。

已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。

```java
示例 1：

输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
输出：true
解释：2 到 5 的每个整数都被覆盖了：

- 2 被第一个区间覆盖。
- 3 和 4 被第二个区间覆盖。
- 5 被第三个区间覆盖。
  示例 2：

输入：ranges = [[1,10],[10,20]], left = 21, right = 21
输出：false
解释：21 没有被任何一个区间覆盖。
```

```java
提示：

1 <= ranges.length <= 50
1 <= starti <= endi <= 50
1 <= left <= right <= 50
```


链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered

## 解题记录

+ 通过统计ranges中的每个值在 left和range中出现的情况，然后判断是否有没有出现的

```java
/**
 * @author: ffzs
 * @Date: 2021/7/23 上午6:53
 */
public class Solution {

    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] tmp = new boolean[right - left + 1];

        for (int[] range : ranges) {
            for (int i = Math.max(range[0], left); i <= Math.min(range[1], right); i++) {
                tmp[i-left] = true;
            }
        }

        for (boolean b : tmp) {
            if (!b) return b;
        }
        return true;
    }

}
```

![image-20210723071400918](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210723071400918.png)