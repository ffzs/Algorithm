## 650. 只有两个键的键盘

## 题目

最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：

Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
Paste（粘贴）：粘贴 上一次 复制的字符。
给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。

```java
示例 1：

输入：3
输出：3
解释：
最初, 只有一个字符 'A'。
第 1 步, 使用 Copy All 操作。
第 2 步, 使用 Paste 操作来获得 'AA'。
第 3 步, 使用 Paste 操作来获得 'AAA'。
示例 2：

输入：n = 1
输出：0
```

```java
提示：

1 <= n <= 1000
```


链接：https://leetcode-cn.com/problems/2-keys-keyboard

## 解题记录

+ 通过因式分解求出结果

```java
/**
 * @author: ffzs
 * @Date: 2021/9/19 上午6:56
 */
public class Solution {

    public int minSteps(int n) {
        int res = 0;
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                n /= i;
                res += i;
            }
        }
        if (n > 1) res += n;
        return res;
    }

}
```

![image-20210919071731805](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210919071731805.png)