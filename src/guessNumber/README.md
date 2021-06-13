## 374. 猜数字大小

## 题目

猜数字游戏的规则如下：

每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：

-1：我选出的数字比你猜的数字小 pick < num
1：我选出的数字比你猜的数字大 pick > num
0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
返回我选出的数字。

 

```java
示例 1：

输入：n = 10, pick = 6
输出：6
示例 2：

输入：n = 1, pick = 1
输出：1
示例 3：

输入：n = 2, pick = 1
输出：1
示例 4：

输入：n = 2, pick = 2
输出：2
```



```java
提示：

1 <= n <= 231 - 1
1 <= pick <= n
```


链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower

## 解题记录

+ 直接二分查找即可

```java
/**
 * @author: ffzs
 * @Date: 2021/6/14 上午7:06
 */

class GuessGame {
    public int guess(int num){
        return 1;
    }
}

public class Solution extends GuessGame {

    public int guessNumber(int n) {
        int l = 1, r = n;

        while (l < r) {
            int mid = (l + r) >>> 1;

            if (guess(mid) == 0) return mid;
            else if (guess(mid) == 1) l = mid + 1;
            else r = mid;
        }

        return l;
    }

}
```

![image-20210614071657856](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210614071657856.png)