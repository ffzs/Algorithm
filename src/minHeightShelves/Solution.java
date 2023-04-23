package minHeightShelves;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/4/23 上午8:44
 */
public class Solution {

    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE >> 1);
        dp[0] = 0;
        int totalWidth = 0, maxHeight = 0;
        for (int i = 0; i < n; i++) {
            totalWidth = 0;
            maxHeight = 0;
            for (int j = i; j >= 0; j--) {
                totalWidth += books[j][0];
                if (totalWidth > shelfWidth) break;
                maxHeight = Math.max(books[j][1], maxHeight);
                dp[i+1] = Math.min(dp[i+1], dp[j] + maxHeight);
            }
        }

        return dp[n];
    }

}
