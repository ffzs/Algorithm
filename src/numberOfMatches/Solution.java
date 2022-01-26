package numberOfMatches;

/**
 * @author: ffzs
 * @Date: 2022/1/25 上午8:29
 */
public class Solution {
    int res = 0;
    public int numberOfMatches(int n) {
        if (n == 1) return res;
        if ((n & 1) == 1) {
            res += (n - 1) / 2;
            return numberOfMatches((n - 1) / 2 + 1);
        }
        else {
            res += n / 2;
            return numberOfMatches(n / 2);
        }
    }
}
