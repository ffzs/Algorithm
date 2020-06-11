package superEggDrop;

import java.util.Arrays;

public class superEggDrop {
    public static int superEggDrop(int K, int N) {
        int[] dp = new int[K + 1];
        int t = 0;
        for (int n=0; n<N; ++n){
            for (int i = K; i > 0; --i) dp[i] = dp[i] + dp[i-1] + 1;
            t++;
            if (dp[K]>=N) return t;
        }
        return t;
    }


    public static void main(String[] args) {
        int K = 2;
        int N = 20;
        System.out.println(superEggDrop(K, N));
    }
}
