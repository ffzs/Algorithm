package countPrimes;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2020/12/3 上午7:36
 */
public class Solution {

    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) res++;
        }
        return res;
    }

    private boolean isPrimes (int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(10));
    }
}
