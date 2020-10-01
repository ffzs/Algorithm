## [LCP 19. 秋叶收藏集](https://leetcode-cn.com/problems/UlBDOe/)

## 题目

小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。

```java
示例 1：
输入：leaves = "rrryyyrryyyrr"
输出：2
解释：调整两次，将中间的两片红叶替换成黄叶，得到 "rrryyyyyyyyrr"
```

```java
示例 2：
输入：leaves = "ryr"
输出：0
解释：已符合要求，不需要额外操作
```

```java
提示：
3 <= leaves.length <= 10^5
leaves 中只包含字符 'r' 和字符 'y'
```

链接：https://leetcode-cn.com/problems/UlBDOe

## 解题记录

+ 通过动态规划求解
+ 通过三个状态记录：
  + 0：前面的红色需要转换
  + 1：中间黄色需要的转换
  + 2：最后的红色需要的转换
  + 1可以通过0中过渡而来，也可以通过1中前一个而来
  + 2可以通过1过渡而来，也可以通过2中前一个而来

```java
/**
 * @author: ffzs
 * @Date: 2020/10/1 上午7:01
 */

public class Solution {

    public int minimumOperations(String leaves) {
        int res = 0;
        char[] seq = leaves.toCharArray();
        List<Integer> tmp = new ArrayList<>();
        if (seq[0] != 'r') {
            seq[0] = 'r';
            res++;
        }
        if (seq[seq.length-1] != 'r') {
            seq[seq.length-1] = 'r';
            res++;
        }

        int count = 0;
        int n = 1;
        char start = seq[0];

        for (char c : seq) {
            if (c != start) {
                start = c;
                tmp.add(count);
                count = 1;
                n++;
            } else count++;
        }

        tmp.add(count);
        if (n == 3) return res;
        if (n == 1) return res+1;
        int[][] dp = new int[3][n];
        dp[0][0] = 0;
        dp[1][0] = dp[2][1] = Integer.MAX_VALUE;
        for (int i = 1; i < tmp.size(); i++) {
            int isRed = (i&1) == 0 ? tmp.get(i):0;
            int isYellow = (i&1) == 1 ? tmp.get(i):0;
            dp[0][i] = dp[0][i-1] + isYellow;
            dp[1][i] = Math.min(dp[0][i-1], dp[1][i-1]) + isRed;
            if (i >= 2) dp[2][i] = Math.min(dp[1][i-1], dp[2][i-1]) + isYellow;
        }
        return dp[2][n-1] + res;
    }
}
```

![image-20201001090234130](README.assets/image-20201001090234130.png)

## 进阶

+ 使用前缀和
+ 在处理完开头和结尾的红色之后区间（i,j）为颜色混合区，需要处理
+ 在这个区间红色和黄色总是交替出现，通过记录每一对红黄转换的差值，来判断最优情况
+ max代表最终的黄色部分大小，max越大，黄色转化为红色的就越少，也就是结果越小
+ pre是前缀的积累
+ min_pre是黄色优于红色的积累

```java
/**
 * @author: ffzs
 * @Date: 2020/10/1 上午9:02
 */
public class Solution2 {

    public int minimumOperations(String leaves) {
        char[] seq = leaves.toCharArray();
        int res = 0, i = 0, j = seq.length-1;
        if (seq[0] != 'r') {
            seq[0] = 'r';
            res++;
        }
        if (seq[seq.length-1] != 'r') {
            seq[seq.length-1] = 'r';
            res++;
        }
        // 将两边的red去掉
        while (i<seq.length && seq[i] == 'r') i++;
        while (j >=0 && seq[j] == 'r') j--;

        if (i > j) return res + 1;
        int max = 0, pre = 0, min_pre = seq.length;
        int yellow = 0;
        while (i <= j) {
            int tmp = 0;
            if (seq[i] == 'y') {
                while (seq[i] == 'y') {
                    i++; tmp++;
                }
                yellow += tmp;
                pre += tmp;
                max = Math.max(max, pre);
                if (min_pre != seq.length) max = Math.max(max, pre-min_pre);
            }
            else {
                while (seq[i] == 'r') {
                    i++; tmp++;
                }
                pre -= tmp;
                min_pre = Math.min(pre, min_pre);
            }
        }
        return res + yellow -max;
    }
}
```

![image-20201001094630790](README.assets/image-20201001094630790.png)