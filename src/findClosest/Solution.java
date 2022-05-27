package findClosest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/5/27 上午8:54
 */
public class Solution {

    public int findClosest(String[] words, String word1, String word2) {
        int i1 = -1, i2 = -1, n = words.length;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String w = words[i];
            if (w.equals(word1)) {
                i1 = i;
                if (i2 != -1) {
                    res = Math.min(res, Math.abs(i1 - i2));
                    if (res == 1) return 1;
                }
            }
            else if (w.equals(word2)) {
                i2 = i;
                if (i1 != -1) {
                    res = Math.min(res, Math.abs(i1 - i2));
                    if (res == 1) return 1;
                }
            }
        }
        return res;
    }
}
