## 149. 直线上最多的点数

## 题目

给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。

```java
 示例 1：


输入：points = [[1,1],[2,2],[3,3]]
输出：3
示例 2：


输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
输出：4
```




```java
提示：

1 <= points.length <= 300
points[i].length == 2
-104 <= xi, yi <= 104
points 中的所有点 互不相同
```


链接：https://leetcode-cn.com/problems/max-points-on-a-line

## 解题记录

+ 通过比较一个点相连的两点的连线的斜率来判断是否位于一条直线
+ 斜率可以通过约分到最小情况，因为浮点数精度不够
+ 或是通过直接通过相乘比较两个条线段是否斜率一样 `x1/y1=x2/y2 -> x1*y2=x2*y1`

```java
/**
 * @author: ffzs
 * @Date: 2021/6/24 上午7:05
 */
public class Solution {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (res >= n - i || res > n / 2) break;
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];

                if (x == 0) y = 1;
                else if (y == 0) x = 1;
                else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }

                    int g = gcd(Math.abs(x), Math.abs(y));

                    x /= g;
                    y /= g;
                }

                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                res = Math.max(res, e.getValue() + 1);
            }
        }
        return res;
    }

    private int gcd(int x, int y) {
        if (y == 0) return x;
        else return gcd(y, x % y);
    }


    public int maxPoints2(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (res >= n - i || res > n / 2) break;
            for (int j = i + 1; j < n; j++) {
                int cnt = 2;
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                for (int k = j + 1; k < n; k++) {
                    if (((points[i][0] - points[k][0]) * y) == (points[i][1] - points[k][1]) * x ) cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}
```

![image-20210624074248207](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210624074248207.png)