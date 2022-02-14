package maxNumberOfBalloons;

import java.awt.*;
import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/2/13 上午8:50
 *
 */
public class Solution {

    public int maxNumberOfBalloons(String text) {
        int[] take = new int[26];
        take['a' - 'a'] = 1;
        take['b' - 'a'] = 1;
        take['l' - 'a'] = 2;
        take['o' - 'a'] = 2;
        take['n' - 'a'] = 1;
        int[] cnt = new int[26];
        for (char c : text.toCharArray()) {
            cnt[c - 'a']++;
        }
        int res = text.length();
        for (int i = 0; i < take.length; i++) {
            if (take[i] != 0) res = Math.min(res, cnt[i]/take[i]);
        }
        return res;
    }

}
