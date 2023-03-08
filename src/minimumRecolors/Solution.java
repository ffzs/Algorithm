package minimumRecolors;

/**
 * @author: ffzs
 * @Date: 2023/3/9 上午6:29
 */
public class Solution {

    public int minimumRecolors(String blocks, int k) {
        char[] cs = blocks.toCharArray();
        int n = blocks.length();
        int wc = 0, i = 0;
        for (; i < k; i++) {
            if (cs[i] == 'B') wc += 1;
        }
        int res = wc;
        for (; i < n; i++) {
            if (cs[i] == 'B') wc += 1;
            if (cs[i-k] == 'B') wc -= 1;
            if (wc > res) {
                res = wc;
                if (res == k) return 0;
            }
        }
        return k - res;
    }

}
