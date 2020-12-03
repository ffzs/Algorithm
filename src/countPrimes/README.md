## [204. 计数质数](https://leetcode-cn.com/problems/count-primes/)

## 题目

统计所有小于非负整数 n 的质数的数量。

```java
示例 1：
输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
    
示例 2：
输入：n = 0
输出：0
    
示例 3：
输入：n = 1
输出：0
```


提示：

0 <= n <= 5 * 106


链接：https://leetcode-cn.com/problems/count-primes

## 解题记录

+ 暴力枚举法被卡时间了没有通过
+ 埃式筛，如果被4是合数，那么4的倍数也能合数，因此通过确定为合数以后将其倍数也确定为合数来缩小排查范围

```java
/**
 * @author: ffzs
 * @Date: 2020/12/3 上午8:06
 */
public class Solution2 {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] tmp = new boolean[n];
        int res = 1;
        for (int i = 3; i < n; i += 2) {
            if (!tmp[i]) {
                res ++;
                if ((long)i*i < n) {
                    for (int j = i*i; j < n; j += i) {
                        tmp[j] = true;
                    }
                }
            }
        }
        return res;
    }
}
```

![image-20201203081704835](https://gitee.com/ffzs/picture_go/raw/master/img/image-20201203081704835.png)