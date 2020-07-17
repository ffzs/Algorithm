## [174. 地下城游戏](https://leetcode-cn.com/problems/dungeon-game/)

## 题目

一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。

骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。

有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。

为了尽快到达公主，骑士决定每次只向右或向下移动一步。

 

编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。

例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。

-2 (K)	-3	3
-5	-10	1
10	30	-5 (P)

```java
说明:

骑士的健康点数没有上限。
任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
```


链接：https://leetcode-cn.com/problems/dungeon-game

## 解题记录

+ 通过动态规划求解，通过反向dp求解，正向dp很麻烦，因为不能合理给出初始状态值，要考虑上左dp和`dp[y][x]`大小关系来判断是选取上还是左，需要判断很多
+ 反向dp就简单的多了，设置初始dp为1
+ `dp[i][j]`可以由`dp[i+1][j]`或`dp[i][j+1]`-`dungeon[i][j]`得到
+ `dp[i][j]`不能小于1
+  因为要求最小，那么在`dp[i+1][j]`和`dp[i][j+1]`中取最小值

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/7/12
 */
public class Solution {
    public static int calculateMinimumHP(int[][] dungeon) {
        int y = dungeon.length, x = dungeon[0].length;
        int[][] dp = new int[y+1][x+1];
        for (int i = 0; i < x; i++) dp[y][i] = Integer.MAX_VALUE;
        for (int i = 0; i < y; i++) dp[i][x] = Integer.MAX_VALUE;
        dp[y][x-1] = 1;
        for (int j = x-1; j >= 0; --j) {
            for (int i = y-1; i >= 0; --i) {
                dp[i][j] = Math.max(Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5,-10,1}, {10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
    }
}

```

![image-20200712195336643](README.assets/image-20200712195336643.png)

## 深度优先

+ 思路其实跟动态规划相仿
+ 通过使用递归进行深度优先搜索

```java
/**
 * @author ffzs
 * @describe
 * @date 2020/7/12
 */
public class Solution2 {
    static int[][] dg, dp;
    static int x, y;
    public static int calculateMinimumHP(int[][] dungeon) {
        y = dungeon.length;
        x = dungeon[0].length;
        dg = dungeon;
        dp = new int[y][x];

        return dfs(0,0);
    }

    private static int dfs (int i, int j) {
        if (i == y - 1&&j == x - 1) return Math.max(1 - dg[i][j], 1);

        if (dp[i][j] != 0) return dp[i][j];

        if (i == y-1) dp[i][j] = Math.max(dfs(i,j+1)-dg[i][j], 1);
        else if (j == x - 1) dp[i][j] = Math.max(dfs(i+1,j)-dg[i][j], 1);
        else dp[i][j] = Math.max(Math.min(dfs(i+1,j), dfs(i, j+1))-dg[i][j], 1);

        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] dungeon = {{-2, -3, 3}, {-5,-10,1}, {10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
    }
}

```

![image-20200712200307919](README.assets/image-20200712200307919.png)