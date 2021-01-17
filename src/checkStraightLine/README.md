## [1232. 缀点成线](https://leetcode-cn.com/problems/check-if-it-is-a-straight-line/)

## 题目

在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。

请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。

 

```java
示例 1：

输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
输出：true
示例 2：

输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
输出：false
```

```java
提示：

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates 中不含重复的点
```


链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line

## 

## 解题记录

+ 通过计算不同点之间的斜率如果相同的话就是在一条直线上

```java
/**
 * @author: ffzs
 * @Date: 2021/1/17 下午5:20
 */
public class Solution {

    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n <= 2) return true;


        for (int i = 1; i < n-1; i++) {
            if ((coordinates[i+1][1] - coordinates[i][1])*(coordinates[i][0] - coordinates[i-1][0]) != (coordinates[i][1] - coordinates[i-1][1])*(coordinates[i+1][0] - coordinates[i][0])) {
                return false;
            }
        }
        return true;
    }
}
```

![image-20210117173326533](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210117173326533.png)