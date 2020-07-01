package findLength;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/1
 */
public class Solution3 {
    public static int findLength(int[] A, int[] B) {
        int res = 0;
        int[] dp = new int[B.length + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = B.length; j >= 1 ; --j) {
                if (A[i] == B[j-1]) {
                    dp[j] = dp[j-1] + 1;
                    res = Math.max(dp[j], res);
                }
                else dp[j] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        System.out.println(findLength(A, B));
    }
}
