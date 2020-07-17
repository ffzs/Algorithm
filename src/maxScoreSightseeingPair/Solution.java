package maxScoreSightseeingPair;



/**
 * @author ffzs
 * @describe
 * @date 2020/6/17
 */
public class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int max = 0, left = A[0];
        for (int i = 1; i < A.length; i++) {
            max = Math.max(max, left + A[i] -i);
            left = Math.max(left, A[i]+i);
        }
        return max;
    }
}
