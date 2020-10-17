## [52. N皇后 II](https://leetcode-cn.com/problems/n-queens-ii/)

## 题目

n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

![image-20201017075300689](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201017075300689.png)

上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

```java
示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
```


提示：

皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或 N-1 步，可进可退。（引用自 百度百科 - 皇后 ）


链接：https://leetcode-cn.com/problems/n-queens-ii

## 解题记录

+ 与[Leetcode: NO.51 N 皇后 回溯算法](https://blog.csdn.net/tonydz0523/article/details/108375964)算法逻辑一样，只不过是最后统计个数
+ 因为不输出形状，因此也不需要再记录形状

```java
/**
 * @author: ffzs
 * @Date: 2020/10/17 上午7:45
 */

public class Solution {

    int res = 0;
    boolean[] column, rightDown, leftDown;
    int n;

    public int totalNQueens(int n) {
        this.n = n;
        this.column = new boolean[n];
        this.rightDown = new boolean[n*2-1];
        this.leftDown = new boolean[n*2-1];
        dfs(0);
        return res;
    }

    private void dfs (int r) {
        if (r==n){
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int right = r-i+n-1;
            int left = r+i;
            if (!column[i] && !rightDown[right] && !leftDown[left]) {
                column[i] = rightDown[right] = leftDown[left] = true;
                dfs(r+1);
                // 回溯
                column[i] = rightDown[right] = leftDown[left] = false;
            }
        }
    }
}
```

![image-20201017080251968](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201017080251968.png)

## 进阶

+ 通过二进制位运算记录信息
+ 因为状态都是新生成的int值因此不需要回溯
+ *x* & (−*x*) 可以获得 x*x* 的二进制表示中的最低位的 1 的位置；
+ *x* & (*x*−1) 可以将 x*x* 的二进制表示中的最低位的 1 置成 0。

```java
/**
 * @author: ffzs
 * @Date: 2020/10/17 上午8:48
 */
public class Solution2 {

    int count = 0, n;
    public int totalNQueens(int n) {
        this.n = n;
        dfs(0,0,0,0);
        return count;
    }

    private void dfs (int row, int col, int left, int right) {
        if (row == n) {
            count++;
            return;
        }

        int available = ((1 << n) -1) & (~(col|left|right));
        while (available != 0) {
            int pos = -available & available;
            available -= pos;
            dfs(row+1, col|pos, (left|pos)<<1, (right|pos)>>1);
        }
    }
}
```

![image-20201017090045380](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201017090045380.png)