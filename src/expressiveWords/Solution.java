package expressiveWords;

/**
 * @author: ffzs
 * @Date: 2022/11/25 上午9:12
 */
public class Solution {

    public int expressiveWords(String s, String[] words) {
        int n = s.length();
        int[][] cs = new int[n][2];
        int i = 0, idx = 0;
        while (i < n) {
            int j = i + 1, c = s.charAt(i);
            while (j < n && s.charAt(j) == c) j += 1;
            cs[idx++] = new int[]{c, j - i};
            i = j;
        }
        int res = 0;
        for (String word : words) {
            if (match(cs, word)) res += 1;
        }
        return res;
    }

    private boolean match (int[][] cs, String s) {
        int n = s.length();
        int i = 0, idx = 0;
        while (i < n) {
            if (idx >= cs.length) return false;
            int j = i + 1, c = s.charAt(i);
            if (cs[idx][0] != c) return false;
            while (j < n && s.charAt(j) == c) j += 1;
            if (cs[idx][1] < j - i || (cs[idx][1] == 2 && j - i == 1)) return false;
            idx += 1;
            i = j;
        }
        return cs[idx][0] == 0;
    }

}
