package maxScore;

/**
 * @author: ffzs
 * @Date: 2021/2/6 上午8:50
 */
public class Solution2 {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int  sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        int res = sum;
        for (int i = 0; i < k; i++) {
            sum += (cardPoints[n-i-1] - cardPoints[k-1-i]);
            res = Math.max(res, sum);
        }
        return res;
    }

}
