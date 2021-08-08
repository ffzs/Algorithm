package tribonacci;

/**
 * @author: ffzs
 * @Date: 2021/8/8 下午1:18
 */
public class Solution {

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1|| n == 2) return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int t = a;
            a = b;
            b = c;
            c = a + b + t;
        }
        return c;
    }

}
