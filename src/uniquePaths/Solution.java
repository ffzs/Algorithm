package uniquePaths;

/**
 * @author: ffzs
 * @Date: 2020/12/9 上午8:43
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        long res = 1;
        for (int i = 1, j = n; i < m; i++, j++) {
            res = res * j / i;
        }
        return (int) res;
    }
}
