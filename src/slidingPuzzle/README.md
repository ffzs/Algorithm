## 773. 滑动谜题

## 题目

在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.

一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.

最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。

给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。

```java
示例：

输入：board = [[1,2,3],[4,0,5]]
输出：1
解释：交换 0 和 5 ，1 步完成
输入：board = [[1,2,3],[5,4,0]]
输出：-1
解释：没有办法完成谜板
输入：board = [[4,1,2],[5,0,3]]
输出：5
解释：
最少完成谜板的最少移动次数是 5 ，
一种移动路径:
尚未移动: [[4,1,2],[5,0,3]]
移动 1 次: [[4,1,2],[0,5,3]]
移动 2 次: [[0,1,2],[4,5,3]]
移动 3 次: [[1,0,2],[4,5,3]]
移动 4 次: [[1,2,0],[4,5,3]]
移动 5 次: [[1,2,3],[4,5,0]]
输入：board = [[3,2,4],[1,5,0]]
输出：14
```



```java
提示：

board 是一个如上所述的 2 x 3 的数组.
board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
```


链接：https://leetcode-cn.com/problems/sliding-puzzle

## 解题记录

+ 双向BFS进行搜索
+ 通过set记录，记录的时候可以转化为字符串



## 进阶

+ 启发式搜索，通过设置每个节点的搜索距离，然后通过一个优先队列记录局部搜索的最短情况
+ 通过弹出最短进行搜索，可以节省时间

```java
/**
 * @author: ffzs
 * @Date: 2021/6/26 上午9:41
 */

class AStar{
    public static int[][] dist = {
            {0,1,2,1,2,3},
            {1,0,1,2,1,2},
            {2,1,0,3,2,1},
            {1,2,3,0,1,2},
            {2,1,2,1,0,1},
            {3,2,1,2,1,0}
    };

    public String status;
    public int f, g, h;

    public AStar(String status, int g) {
        this.status = status;
        this.g = g;
        this.h = getH(status);
        this.f = this.g + this.h;
    }

    private static int getH(String status) {
        int ret = 0;
        for (int i = 0; i < 6; i++) {
            int cur = status.charAt(i);
            if (cur != '0') {
                ret += dist[i][cur - '1'];
            }
        }
        return ret;
    }
}

public class Solution {

    int[][] neighbors = {{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();

        if (initial.equals("123450")) return 0;

        PriorityQueue<AStar> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.f));

        pq.offer(new AStar(initial, 0));

        Set<String> seen = new HashSet<>();
        seen.add(initial);

        while (!pq.isEmpty()) {
            AStar cur = pq.poll();
            for (String s : getNext(cur.status)) {
                if (!seen.contains(s)) {
                    if ("123450".equals(s)) return cur.g + 1;
                    pq.offer(new AStar(s, cur.g + 1));
                    seen.add(s);
                }
            }
        }
        return -1;
    }

    private List<String> getNext(String status){
        List<String> ret = new ArrayList<>();
        char[] cs = status.toCharArray();

        int x = status.indexOf('0');
        for(int y: neighbors[x]){
            swap(cs, x, y);
            ret.add(new String(cs));
            swap(cs, x, y);
        }
        return ret;
    }

    private void swap(char[] cs, int x, int y) {
        char tmp = cs[x];
        cs[x] = cs[y];
        cs[y] = tmp;
    }

}
```

![image-20210626113225094](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210626113225094.png)