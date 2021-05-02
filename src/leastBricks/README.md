## 554. 砖墙

## 题目

你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。

你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。

给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。

 

```java
示例 1：
输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
输出：2

示例 2：
输入：wall = [[1],[1],[1]]
输出：3
```



```java
提示：

n == wall.length
1 <= n <= 104
1 <= wall[i].length <= 104
1 <= sum(wall[i].length) <= 2 * 104
对于每一行 i ，sum(wall[i]) 应当是相同的
1 <= wall[i][j] <= 231 - 1
```


链接：https://leetcode-cn.com/problems/brick-wall

## 解题记录

+ 本题并不难，根据题意可以将问题转化为记录每一个col边缘有多少个砖缝的问题
+ 通过一个map进行统计即可，也就是说，砖缝越多，穿越的砖头就越少
+ 有一点要注意一下就是因为$1 <= sum(wall[i].length) <= 2 * 10^4$,不能使用数组进行存储个数情况会超出内存

```java
/**
 * @author: ffzs
 * @Date: 2021/5/2 上午7:58
 */
public class Solution {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            int v = item.getValue();
            if (v != 0 && v > res) res = v;
        }

        return wall.size() - res;
    }
}
```

![image-20210502090103716](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210502090103716.png)