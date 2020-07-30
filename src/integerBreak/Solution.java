package integerBreak;

/**
 * @author: ffzs
 * @Date: 2020/7/30 上午9:14
 */
public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int n3 = n/3;
        int remainder = n % 3;
        if (remainder == 0) return (int) Math.pow(3, n3);
        else if (remainder == 1) return (int) Math.pow(3, n3 - 1) * 4;
        else return (int) Math.pow(3, n3) * 2;
    }
}
