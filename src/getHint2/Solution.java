package getHint2;

/**
 * @author: ffzs
 * @Date: 2024/3/10 下午6:42
 */
public class Solution {

    public String getHint(String secret, String guess) {
        int[] sCnt = new int[10];
        int[] gCnt = new int[10];
        int[] bulls = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char a = secret.charAt(i);
            char b = guess.charAt(i);
            if (a == b) bulls[a - '0'] += 1;
            sCnt[a - '0'] += 1;
            gCnt[b - '0'] += 1;
        }

        int A = 0, B = 0;
        for (int i = 0; i < 10; i++) {
            B += Math.min(sCnt[i], gCnt[i]);
        }
        for (int bull : bulls) {
            A += bull;
        }

        return A + "A" + (B-A) + "B";
    }

}
