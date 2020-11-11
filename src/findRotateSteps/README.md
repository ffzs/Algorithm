## [514. 自由之路](https://leetcode-cn.com/problems/freedom-trail/)

## 题目

视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。

给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。

最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。

旋转 ring 拼出 key 字符 key[i] 的阶段中：

您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
示例：

 ![image-20201111091539972](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201111091539972.png)



```java
输入: ring = "godding", key = "gd"
输出: 4
解释:
 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。 
 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 当然, 我们还需要1步进行拼写。
 因此最终的输出是 4。
```


提示：

ring 和 key 的字符串长度取值范围均为 1 至 100；
两个字符串中都只有小写字符，并且均可能存在重复字符；
字符串 key 一定可以由字符串 ring 旋转拼出。


链接：https://leetcode-cn.com/problems/freedom-trail

## 解题记录

![在这里插入图片描述](https://gitee.com/ffzs/picture_go/raw/master/img/20201111094553135.png)

+ 由于有的字符有多个，因此使用动态规划求解
+ 由于转盘是可以顺逆时针进行旋转的，因此最优步数是min(abs(i1-i2), n-abs(i1-i2)),就是可以通过正向获取也可以通过逆向获取
+ 最后获取最后一列中最小值为移动的步数，在加上输入的步数就是key的长度即为所求



```java
/**
 * @author: ffzs
 * @Date: 2020/11/11 上午9:14
 */
public class Solution {

    public int findRotateSteps(String ring, String key) {
        char[] rc = ring.toCharArray();
        char[] kc = key.toCharArray();
        int n = rc.length, m = kc.length;
        List<Integer>[] tmp = new List[26];
        for (int i = 0; i < 26; i++) tmp[i] = new ArrayList<>();
        for (int i = 0; i < rc.length; i++) tmp[rc[i] - 'a'].add(i);

        int[][] dp = new int[m][n];
        for (int[] ints : dp) Arrays.fill(ints, Integer.MAX_VALUE);

        for (int i : tmp[kc[0]-'a']) {
            dp[0][i] = Math.min(i, n-i);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j : tmp[kc[i]-'a']) {
                for (int k : tmp[kc[i - 1] - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.min(Math.abs(j-k), n-Math.abs(j-k)));
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i : dp[m - 1]) {
            res = Math.min(res, i);
        }
        return res + m;
    }

}
```

![image-20201111101824862](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201111101824862.png)