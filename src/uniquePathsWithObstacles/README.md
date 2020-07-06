## [63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)

## 题目



一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

![img](README.assets/robot_maze.png)

网格中的障碍物和空位置分别用 1 和 0 来表示。

说明：m 和 n 的值均不超过 100。

```java
示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：

1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右



```

链接：https://leetcode-cn.com/problems/unique-paths-ii



## 解题记录

+ 通过动态规划求解
+ 如果是1的话改点的dp为0，即不做处理
+ 如果为0的话,因为是通过左边或者上边到达，因此`dp[i][j]= dp[i-1][j] + dp[i][j-1]`
+ 为了不判断边界，在dp数组左边和上边添加了一层

```java

/**
 * @author ffzs
 * @describe
 * @date 2020/7/6
 */
public class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int y = obstacleGrid.length;
        int x = obstacleGrid[0].length;
        int[][] dp = new int[y+1][x+1];
        dp[0][1] = 1;
        System.out.println(Arrays.deepToString(dp));
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (obstacleGrid[i][j] == 0){
                    dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[y][x];
    }

    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};
        int[][] obstacleGrid = {{0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}

```

![image-20200706095739613](README.assets/image-20200706095739613.png)