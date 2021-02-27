package longestSubstring;

/**
 * @author: ffzs
 * @Date: 2021/2/27 上午9:50
 */
public class Solution2 {

    public int longestSubstring(String s, int k) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        return dfs(cs, 0, n-1, k);
    }

    private int dfs (char[] cs, int l, int r, int k) {
        int[] cnt = new int[26];

        for (int i = l; i <= r; i++) {
            cnt[cs[i] - 'a'] ++;
        }

        char pos = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                pos = (char)(i + 'a');
                break;
            }
        }

        if (pos == 0) return r - l + 1;

        int i = l, ret = 0;

        while (i < r) {
            while (i <= r && cs[i] == pos) i++;
            if (i > r) break;
            int start = i;
            while (i <= r && cs[i] != pos) i++;
            int gap = dfs(cs, start, i - 1, k);
            ret = Math.max(ret, gap);
        }
        return ret;
    }

}
