package others;

import java.util.Arrays;
import java.util.List;

public class minDistance {
    public static int minDistance(String word1, String word2) {
        char[] seq1 = word1.toCharArray();
        char[] seq2 = word2.toCharArray();
        int[][] dp = new int[seq1.length + 1][seq2.length + 1];

        for (int i = 0; i <= seq1.length; i++) {
            for (int j = 0; j <= seq2.length; j++) {
                if (i==0) dp[i][j] = j;
                else if (j==0) dp[i][j] = i;
                else if (seq1[i - 1] == seq2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[seq1.length][seq2.length];
    }

    public static void main(String[] args) {
        String ch1 = "sea";
        String ch2 = "eat";
        System.out.println(minDistance(ch1, ch2));
    }
}
