package minimumOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/10/1 上午7:01
 */

public class Solution {

    public int minimumOperations(String leaves) {
        int res = 0;
        char[] seq = leaves.toCharArray();
        List<Integer> tmp = new ArrayList<>();
        if (seq[0] != 'r') {
            seq[0] = 'r';
            res++;
        }
        if (seq[seq.length-1] != 'r') {
            seq[seq.length-1] = 'r';
            res++;
        }

        int count = 0;
        int n = 1;
        char start = seq[0];

        for (char c : seq) {
            if (c != start) {
                start = c;
                tmp.add(count);
                count = 1;
                n++;
            } else count++;
        }

        tmp.add(count);
        if (n == 3) return res;
        if (n == 1) return res+1;
        int[][] dp = new int[3][n];
        dp[0][0] = 0;
        dp[1][0] = dp[2][1] = Integer.MAX_VALUE;
        for (int i = 1; i < tmp.size(); i++) {
            int isRed = (i&1) == 0 ? tmp.get(i):0;
            int isYellow = (i&1) == 1 ? tmp.get(i):0;
            dp[0][i] = dp[0][i-1] + isYellow;
            dp[1][i] = Math.min(dp[0][i-1], dp[1][i-1]) + isRed;
            if (i >= 2) dp[2][i] = Math.min(dp[1][i-1], dp[2][i-1]) + isYellow;
        }
        return dp[2][n-1] + res;
    }
}

class Test{
    public static void main(String[] args) {
        String leaves = "rrryyyrryyyrr";
        Solution solution = new Solution();
        System.out.println(solution.minimumOperations(leaves));
    }
}
