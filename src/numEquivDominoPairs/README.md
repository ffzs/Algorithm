## [1128. 等价多米诺骨牌对的数量](https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/)

## 题目

给你一个由一些多米诺骨牌组成的列表 dominoes。

如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。

形式上，`dominoes[i] = [a, b]` 和 `dominoes[j] = [c, d]` 等价的前提是` a==c `且 `b==d`，或是 `a==d` 且 `b==c`。

在` 0 <= i < j < dominoes.length` 的前提下，找出满足 `dominoes[i]` 和 `dominoes[j]` 等价的骨牌对 (i, j) 的数量。

 

```java
示例：

输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
输出：1
```



```java
提示：

1 <= dominoes.length <= 40000
1 <= dominoes[i][j] <= 9
```


链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs

## 解题记录

+ 由于题目中规定数组中值得范围为1~9
+ 通过一个数组存储计数
+ 然后统计个数大于2的组合情况



```java
/**
 * @author: ffzs
 * @Date: 2021/1/26 下午8:02
 */
public class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] tmp = new int[10][10];

        for (int[] dominoe : dominoes) {
            int i = dominoe[0], j = dominoe[1];

            if (i > j) {
                tmp[j][i] ++;
            }
            else{
                tmp[i][j] ++;
            }
        }

        int res = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = i; j < 9; j++) {
                int v = tmp[i][j];
                if (v >= 2) res += sum(v);
            }
        }

        return res;
    }

    private int sum (int i) {
        return ((i-1) * i) / 2;
    }
    
}
```

![image-20210126202708092](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210126202708092.png)