## 313. 超级丑数

## 题目

超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。

给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。

题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。

```java
示例 1：

输入：n = 12, primes = [2,7,13,19]
输出：32 
解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
示例 2：

输入：n = 1, primes = [2,3,5]
输出：1
解释：1 不含质因数，因此它的所有质因数都在质数数组 primes = [2,3,5] 中。
```

```java
提示：

1 <= n <= 106
1 <= primes.length <= 100
2 <= primes[i] <= 1000
题目数据 保证 primes[i] 是一个质数
primes 中的所有值都 互不相同 ，且按 递增顺序 排列
```

链接：https://leetcode-cn.com/problems/super-ugly-number

## 解题记录

+ 最小堆
+ 通过primes每一个都和cur相乘得到可能出现的值，通过hash过滤出现过的，在取出第n次的时候即为目标值
+ 动态规划dp[i] 为第i个丑数，然后通过一个index数值表示下一个丑数通过primes中和dp中的某个值相乘得到，然后找到最小的，最后在此基础上将index中相对应的位置的index+1

```java
/**
 * @author: ffzs
 * @Date: 2021/8/9 上午6:50
 */
public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();

        visited.add(1L);
        pq.offer(1L);

        int res = 0;
        for (int i = 0; i < n; i++) {
            long cur = pq.poll();
            res = (int) cur;
            for (int prime : primes) {
                long it = cur * prime;
                if (visited.add(it)) pq.offer(it);
            }
        }
        return res;
    }


    public int nthSuperUglyNumber2(int n, int[] primes) {
        int len = primes.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int[] index = new int[len];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                min = Math.min(primes[j] * dp[index[j]], min);
            }
            dp[i] = min;

            for (int j = 0; j < len; j++) {
                if (min == primes[j] * dp[index[j]]) index[j]++;
            }
        }
        return dp[n-1];
    }

}
```

![image-20210809072000699](https://gitee.com/ffzs/picture_go/raw/master/img/image-20210809072000699.png)