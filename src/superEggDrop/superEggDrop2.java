package superEggDrop;

import java.util.Arrays;

public class superEggDrop2 {
    public static int superEggDrop(int K, int N) {
        if (N == 1) return 1;
        int[][] dp = new int[N + 1][K + 1];
        for (int k=1; k<=K; ++k){
            dp[1][k] = 1;
        }
        for (int i=2; i<=N; ++i) {
            for(int j=1; j<=K; ++j){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + 1;
            }
            if (dp[i][K] >=N){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int K = 6;
        int N = 5000;
        System.out.println(superEggDrop(K, N));
    }
}
