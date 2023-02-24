package minimumSwap;

/**
 * @author: ffzs
 * @Date: 2023/2/25 上午6:31
 */
public class Solution {

    public int minimumSwap(String s1, String s2) {
        int s1x = 0, s1y = 0, s2x = 0, s2y = 0;
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        for (int i = 0; i < cs1.length; i++) {
            if (cs1[i] == cs2[i]) continue;
            if (cs1[i] == 'x') s1x += 1;
            else s1y += 1;
            if (cs2[i] == 'x') s2x += 1;
            else s2y += 1;
        }
        if ((s1x - s1y) != (s2y - s2x)||((s1x + s1y) & 1) == 1) return -1;
        if ((s1x&1)==0) return (s1x + s1y) / 2;
        return (s1x + s1y) / 2 + 1;
    }

}
