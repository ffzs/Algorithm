package isWinner;

/**
 * @author: ffzs
 * @Date: 2023/12/27 下午8:01
 */
public class Solution {

    public int isWinner(int[] player1, int[] player2) {
        int s1 = calcScore(player1);
        int s2 = calcScore(player2);
        if (s1 == s2) return 0;
        else if (s1 > s2) return 1;
        else return 2;
    }

    private int calcScore (int[] nums) {
        int cnt = 0;
        int ret = 0;
        for (int num : nums) {
            ret += num;
            if (cnt > 0) {
                ret += num;
                cnt--;
            }
            if (num == 10) cnt = 2;
        }
        return ret;
    }

}
