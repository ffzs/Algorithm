package consecutiveNumbersSum;

/**
 * @author: ffzs
 * @Date: 2022/6/3 上午8:46
 * 设第一个数为xx，连续的k个数之和为x+(x+1)+ ... + (x+k-1) = k * x + (1+2+...+k-1) = k * x + k(k-1)/2 (x \ge 1)x+(x+1)+...+(x+k−1)=k∗x+(1+2+...+k−1)=k∗x+k(k−1)/2(x≥1)，计 sum=k(k-1)/2sum=k(k−1)/2。
 * 能表示的条件为n=k * x + k(k-1)/2 (x \ge 1, k \ge 2)n=k∗x+k(k−1)/2(x≥1,k≥2), 即 (n - sum) \mod k = 0(n−sum)modk=0。
 * 依次从k=2k=2开始判断，直到k * x + k(k-1)/2 (x \ge 1) > nk∗x+k(k−1)/2(x≥1)>n，初始为k=2, sum=1k=2,sum=1。
 *
 */
public class Solution {
    public int consecutiveNumbersSum(int n) {
        int res = 1, k = 2, sum = 1;
        while (sum + k <= n) {
            if ((n - sum) % k == 0) res+=1;
            sum += k;
            k+=1;
        }

        return res;
    }
}
