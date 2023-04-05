package commonFactors;

/**
 * @author: ffzs
 * @Date: 2023/4/5 上午9:22
 */
public class Solution {

    public int commonFactors(int a, int b) {
        int g = gcd(a,b);
        int res = 0;
        for (int i = 1; i <= g; i++) {
            if (a % i == 0 && b % i == 0) res += 1;
        }
        return res;
    }

    private int gcd (int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

}
