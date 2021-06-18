package smallestGoodBase;

/**
 * @author: ffzs
 * @Date: 2021/6/18 下午4:58
 */
public class Solution {

    public String smallestGoodBase(String n) {
        long m = Long.parseLong(n);
        int max = (int)(Math.log(m) / Math.log(2) + 1);

        for (int i = max; i >= 3; i--) {
            long k = (long)Math.pow(m ,1.0/(i-1));
            long res = 0;
            for (int j = 0; j < i; j++) res = res * k + 1;
            if (res == m) return String.valueOf(k);
        }
        return String.valueOf(m - 1);
    }

}
