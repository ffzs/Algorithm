package maxScore;

/**
 * @author: ffzs
 * @Date: 2021/2/6 上午8:23
 */
public class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] left = new int[n+1], right = new int[n+1];

        for (int i = 1; i <= n; i++) {
            left[i] = left[i-1] + cardPoints[i-1];
            right[i] = right[i-1] + cardPoints[n-i];
        }

        int res = 0;
        for (int i = 0; i <= k; i++) {
            res = Math.max(res, Math.max(left[i] + right[k-i], left[k-i] + right[i]));
        }
        return res;
    }

}
