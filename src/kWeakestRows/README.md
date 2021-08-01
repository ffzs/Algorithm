## 1337. 矩阵中战斗力最弱的 K 行

## 题目

给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。

请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。

如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。

军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。

 

```java
示例 1：

输入：mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
输出：[2,0,3]
解释：
每行中的军人数目：
行 0 -> 2 
行 1 -> 4 
行 2 -> 1 
行 3 -> 2 
行 4 -> 5 
从最弱到最强对这些行排序后得到 [2,0,3,1,4]
示例 2：

输入：mat = 
[[1,0,0,0],
 [1,1,1,1],
 [1,0,0,0],
 [1,0,0,0]], 
k = 2
输出：[0,2]
解释： 
每行中的军人数目：
行 0 -> 1 
行 1 -> 4 
行 2 -> 1 
行 3 -> 1 
从最弱到最强对这些行排序后得到 [0,2,3,1]
```



```java
提示：

m == mat.length
n == mat[i].length
2 <= n, m <= 100
1 <= k <= m
matrix[i][j] 不是 0 就是 1
```


链接：https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix

## 解题记录

+ 由于军人总在前面，可以通过遍历没一列，通过0找到战斗力弱的队伍
+ 注意最后都是1的情况要处理

```java
/**
 * @author: ffzs
 * @Date: 2021/8/1 上午10:14
 */
public class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        boolean[] visited = new boolean[mat.length];
        int i = 0, col = 0;
        while (i < k && col < mat[0].length) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][col] == 0 && !visited[j]) {
                    res[i++] = j;
                    if (i >= k) break;
                    visited[j] = true;
                }
            }
            col ++;
        }
        for (int j = 0; j < mat.length && i < k; j++) {
            if (!visited[j]) res[i++] = j;
        }
        return res;
    }

}
```

![image-20210801103016931](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210801103016931.png)