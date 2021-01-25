## [959. 由斜杠划分区域](https://leetcode-cn.com/problems/regions-cut-by-slashes/)

## 题目

在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。

（请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。

返回区域的数目。

 

```java
示例 1：
输入：
[
  " /",
  "/ "
]
输出：2
解释：2x2 网格如下：

示例 2：
输入：
[
  " /",
  "  "
]
输出：1
解释：2x2 网格如下：

示例 3：
输入：
[
  "\\/",
  "/\\"
]
输出：4
解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
2x2 网格如下：

示例 4：
输入：
[
  "/\\",
  "\\/"
]
输出：5
解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
2x2 网格如下：

示例 5：
输入：
[
  "//",
  "/ "
]
输出：3
解释：2x2 网格如下：
```

 

```java
提示：

1 <= grid.length == grid[0].length <= 30
grid[i][j] 是 '/'、'\'、或 ' '。
```


链接：https://leetcode-cn.com/problems/regions-cut-by-slashes

## 解题记录

![image-20210125210536167](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210125210536167.png)

+ 可以将一个区域分成4个小区域，通过观察联通情况查看一共有多少个区域
+ `/`的时候0,3联通，1,2联通
+ `\`的时候0,1；2,3联通
+ 当没有到达边界之前将本行的1和本行下一个区域的3相连
+ 本区域的2和本列下一行的0相连

```java
/**
 * @author: ffzs
 * @Date: 2021/1/25 上午8:09
 */

class UnionFind {
    private int[] f;
    private int count;

    public UnionFind(int n) {
        count = n;
        f = new int[n];
        for (int i = 0; i < n; i++) f[i] = i;
    }

    public int find(int i) {
        if (f[i] != i) f[i] = find(f[i]);
        return f[i];
    }

    public void union (int i, int j) {
        int fi = find(i), fj = find(j);
        if (fi != fj) {
            f[find(i)] = find(j);
            count--;
        }
    }

    public int getCount(){
        return count;
    }
}

public class Solution {

    public int regionsBySlashes(String[] grid) {
        int m = grid.length;
        int n = 4*m*m;

        UnionFind uni = new UnionFind(n);

        for (int i = 0; i < m; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < m; j++) {
                int cell = 4 * (i * m + j);
                char c = row[j];
                if (c == '/') {
                    uni.union(cell, cell + 3);
                    uni.union(cell+1, cell + 2);
                }
                else if (c == '\\') {
                    uni.union(cell, cell + 1);
                    uni.union(cell + 2, cell + 3);
                }
                else {
                    uni.union(cell, cell + 1);
                    uni.union(cell + 2, cell + 3);
                    uni.union(cell, cell + 2);
                }

                if (j < m - 1) uni.union(cell + 1, cell + 7);
                if (i < m - 1) uni.union(cell + 2, cell + m * 4);
            }
        }

        return uni.getCount();
    }
}
```

![image-20210125211021848](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210125211021848.png)