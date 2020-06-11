package mincostTickets;

import java.util.Arrays;

public class mincostTickets {
    public static int mincostTickets(int[] days, int[] costs){
        int[] durations = {1,7,30};
        int[] dp = new int[days.length];
        return dp(0, days, costs, durations, dp);
    }

    static int dp(int i, int[] days, int[] costs, int[] durations, int[] dp) {
        if (i>=days.length) return 0;
        if (dp[i]!=0) return dp[i];
        dp[i] = Integer.MAX_VALUE;
        int j = i;
        for (int k=0; k<3; ++k){
            while (j<days.length && days[j]<days[i] + durations[k]) ++j;
            dp[i] = Math.min(dp[i], dp(j, days, costs, durations, dp) + costs[k]);
        }
        return dp[i];
    }

    public static void main(String[] args) {
//        int[] days = {1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
//        int[] costs = {3,13,45};
        int[] days = {4,5,9,11,14,16,17,19,21,22,24};
        int[] costs = {1,4,18};
        System.out.println(mincostTickets(days, costs));
    }
}
