package mincostTickets;

public class mincostTickets2 {
    public static int mincostTickets(int[] days, int[] costs){
        int len = days.length;
        int[] durations = {1,7,30};
        int[] dp = new int[days[len-1]+1];
        int day = 0;
        for (int i=1; i<dp.length; ++i){
            if(i == days[day]) {
                dp[i] = Integer.MAX_VALUE;
                for (int j=0; j<3; ++j){
                    int preDay = Math.max(i - durations[j], 0);
                    dp[i] = Math.min(dp[preDay]+costs[j], dp[i]);
                }
                day++;
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}
