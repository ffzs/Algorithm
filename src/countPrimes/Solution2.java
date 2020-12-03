package countPrimes;

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
