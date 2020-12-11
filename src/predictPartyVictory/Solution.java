package predictPartyVictory;

/**
 * @author: ffzs
 * @Date: 2020/12/11 上午8:09
 */
public class Solution {
    public String predictPartyVictory(String senate) {
        if(senate.length() == 1) return senate.charAt(0) == 'R' ? "Radiant" : "Dire";
        int r = 0, d = 0;
        char[] cs = senate.toCharArray();
        boolean[] ban = new boolean[cs.length];

        for (int i = 0; i < cs.length; i++) {
            if (!ban[i]) continue;
            if (cs[i] == 'R') {
                if (d > 0) {
                    d--;
                    ban[i] = true;
                }else {
                    r++;
                }
            }
            else {
                if (r > 0) {
                    r --;
                    ban[i] = true;
                }
                else {
                    d ++;
                }
            }
        }
        int i = 0;
        while (i < cs.length && (r > 0 || d > 0)) {
            if (cs[i] == 'R' && d > 0) {
                ban[i] = true;
                d--;
            }
            else if (cs[i] == 'D' && r > 0) {
                ban[i] = true;
                r--;
            }
            i++;
        }

        if(r != 0)
            return "Radiant";
        if(d != 0)
            return "Dire";

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < ban.length; j++) {
            if (!ban[j]) sb.append(cs[j]);
        }
        return predictPartyVictory(sb.toString());
    }
}
