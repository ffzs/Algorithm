## [452. 用最少数量的箭引爆气球](https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/)

## 题目

在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。

一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 $x_{start}$，$x_{end}$， 且满足  $x_{start} ≤ x ≤ x_{end}$，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。

给你一个数组 points ，其中 $points [i] = [x_{start},x_{end}]$ ，返回引爆所有气球所必须射出的最小弓箭数。

```java
示例 1：
输入：points = [[10,16],[2,8],[1,6],[7,12]]
输出：2
解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
    
示例 2：
输入：points = [[1,2],[3,4],[5,6],[7,8]]
输出：4
    
示例 3：
输入：points = [[1,2],[2,3],[3,4],[4,5]]
输出：2
    
示例 4：
输入：points = [[1,2]]
输出：1
    
示例 5：
输入：points = [[2,3],[2,3]]
输出：1
```


提示：

0 <= points.length <= 104
points[i].length == 2
$-2^{31} <= xstart < xend <= 2^{31 - 1}$


链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons

## 解题记录

+ 由于数组中产生交集的部分会就会通过一根箭射穿，因此需要统计覆盖范围，在覆盖范围内的可以通过一根箭射穿
+ 如果前一个的最大值小于后一个的最小值，说明不再覆盖范围内，因此需要另外一根箭来处理了

```java
/**
 * @author: ffzs
 * @Date: 2020/11/23 下午3:07
 */
public class Solution {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> {
            if (a[1] > b[1]) return 1;
            else if (a[1] < b[1]) return -1;
            else return 0;
        });

        int start = points[0][1];
        int res = 1;
        for (int[] point : points) {
            if (point[0]>start) {
                start = point[1];
                res++;
            }
        }
        return res;
    }
}
```

![image-20201123170226932](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201123170226932.png)