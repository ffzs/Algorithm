package maximumWealth;

/**
 * @author: ffzs
 * @Date: 2022/4/14 上午8:15
 */
public class Solution {

    public int maximumWealth(int[][] accounts) {
        int res = 0;
        int sum;
        for (int[] account : accounts) {
            sum = 0;
            for (int i : account) {
                sum += i;
            }
            if (sum > res) res = sum;
        }
        return res;
    }
}
