package isNStraightHand;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/12/30 上午8:03
 */
public class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        Arrays.sort(hand);
        boolean[] visited = new boolean[n];
        int start = 0;
        for (int i = 0; i < (n / groupSize); i++) {
            while (visited[start]) start++;
            int l = start;
            for (int j = 0; j < groupSize; j++) {
                int v = hand[start] + j;
                boolean flag = true;
                for (int k = l; k < n; k++) {
                    if (hand[k] == v && !visited[k]) {
                        visited[k] = true;
                        flag = false;
                        l = k;
                        break;
                    }
                }
                if (flag) return false;
            }
        }

        return true;
    }

}
