## 447. 回旋镖的数量

## 题目

给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

返回平面上所有回旋镖的数量。

```java
示例 1：

输入：points = [[0,0],[1,0],[2,0]]
输出：2
解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
示例 2：

输入：points = [[1,1],[2,2],[3,3]]
输出：2
示例 3：

输入：points = [[1,1]]
输出：0
```



```java
提示：

n == points.length
1 <= n <= 500
points[i].length == 2
-104 <= xi, yi <= 104
所有点都 互不相同
```


链接：https://leetcode-cn.com/problems/number-of-boomerangs

## 解题记录

+ 通过枚举距离，然后统计到一个点的距离情况
+ 最后计算出现的符合的pair

```java
/**
 * @author: ffzs
 * @Date: 2021/9/13 上午6:50
 */
public class Solution {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int diffX = points[i][0] - points[j][0];
                int diffY = points[i][1] - points[j][1];
                int len = diffX * diffX + diffY * diffY;
                int cnt = map.getOrDefault(len, 0);
                res += cnt;
                map.put(len, cnt + 1);
            }
            map.clear();
        }

        return res*2;
    }

}
```



![image-20210913070645591](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210913070645591.png)