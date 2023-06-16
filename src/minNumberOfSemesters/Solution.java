package minNumberOfSemesters;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/6/16 上午8:21
 */
public class Solution {

    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int m = (1 << n);
        int[] dp = new int[m], pre = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE >> 1);
        for (int[] r : relations) {
            pre[(1 << (r[1] - 1))] |= 1 << (r[0] - 1);
        }

        dp[0] = 0;
        for (int learn = 1; learn < m; learn++) {
            // i&(i-1) 去掉最后一个1， i&(-i) 获取最后一个1
            // 如 i = 7, bin(7)=111， i&(i-1) = 6 (110) , i&(-i) = 1 (001); 111 = 110 | 001 -> i = i&(i-1) | i&(-i)
            // 将 111 拆分为两个小于 111 的值获取之前的状态实现状态转移， 当然也可以是 100 和 011 ，但是 110 和 001 更容易获取
            pre[learn] = pre[learn&(learn-1)] | pre[learn & (-learn)];
            // 如果学的课程中有些前置课程还没有学那么矛盾
            if ((pre[learn] | learn) != learn) continue;
            // 去掉前置为需要学的
            int remain = learn ^ pre[learn];
            // 所有课程都可以学
            if (Integer.bitCount(remain) <= k)
                dp[learn] = Math.min(dp[learn], dp[pre[learn]] + 1);
            else {
                for (int sub = remain; sub > 0; sub = (sub - 1) & remain) {
                    if (Integer.bitCount(sub) <= k) {
                        dp[learn] = Math.min(dp[learn], dp[learn ^ sub] + 1);
                    }
                }
            }
        }
        return dp[m-1];
    }

}
