package getHint;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/11/8 上午7:29
 */
public class Solution {

    public String getHint(String secret, String guess) {
        int n = secret.length();
        int[] bulls = new int[10];
        int[][] g = new int[10][2];

        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls[secret.charAt(i) - '0'] ++;
            else {
                g[secret.charAt(i) - '0'][0] ++;
                g[guess.charAt(i) - '0'][1] ++;
            }
        }
        System.out.println(Arrays.deepToString(g));
        int x = 0, y = 0;
        for (int i = 0; i < 10; i++) {
            x += bulls[i];
            y += Math.min(g[i][0], g[i][1]);
        }

        return new StringBuilder().append(x).append('A').append(y).append('B').toString();
    }

}
