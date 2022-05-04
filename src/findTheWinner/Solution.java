package findTheWinner;

/**
 * @author: ffzs
 * @Date: 2022/5/4 上午8:41
 */
public class Solution {

    public int findTheWinner(int n, int k) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + k) % i;
        }
        return  res + 1;
    }

}
