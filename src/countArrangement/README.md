## 526. 优美的排列

## 题目

假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：

第 i 位的数字能被 i 整除
i 能被第 i 位上的数字整除
现在给定一个整数 N，请问可以构造多少个优美的排列？

```java
示例1:

输入: 2
输出: 2
解释: 

第 1 个优美的排列是 [1, 2]:
  第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
  第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除

第 2 个优美的排列是 [2, 1]:
  第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
  第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
说明:

N 是一个正整数，并且不会超过15。
```


链接：https://leetcode-cn.com/problems/beautiful-arrangement

## 解题记录

+ 因为改题的N明确不会大于15,因此可以通过一个数字的二进制来表示取数情况
+ 通过位数递增情况添加位数之后是否满足条件，汇总之前出现的情况

```java
/**
 * @author: ffzs
 * @Date: 2021/8/16 上午7:00
 */
public class Solution {

    public int countArrangement(int n) {
        int len = 1<<n;
        int[] f = new int[len];
        f[0] = 1;
        for (int mask = 0; mask < len; mask++) {
            int num = Integer.bitCount(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1<<i)) !=0 && ((num % (i + 1)) == 0 || (i + 1) % num == 0)) {
                    f[mask] += f[mask ^ (1 << i)];
                }
            }
        }
        return f[len-1];
    }
}
```

![image-20210816071208475](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210816071208475.png)