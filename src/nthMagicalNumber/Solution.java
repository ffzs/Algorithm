package nthMagicalNumber;


/**
 * @author: ffzs
 * @Date: 2022/11/22 上午8:45
 */
public class Solution {

    private static final int MOD = (int) 1e9 + 7;
    public int nthMagicalNumber(int n, int a, int b) {
        int lcm = leastCommonMultiple(a ,b);
        int round = lcm / a + lcm / b - 1;
        long res = (long)(n / round) * lcm % MOD;
        int it = n % round;
        if (it == 0) return (int)res;
        int A = a, B = b;
        for (int i = 0; i < it - 1; i++) {
            if (A < B) A += a;
            else B += b;
        }
        return (int)((res + Math.min(A, B))%MOD);
    }

    private int leastCommonMultiple(int a, int b) {
        if (a == b) return a;
        return a * b / greatestCommonDivisor(a, b);
    }

    private int greatestCommonDivisor(int a, int b) {
        if (b == 0) return a;
        return greatestCommonDivisor(b, a % b);
    }

}
