package maxScoreWords;

/**
 * @author: ffzs
 * @Date: 2023/2/26 下午1:32
 */
public class Solution {

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length, res = 0;
        int[] cnt = new int[26];
        for (char c : letters) {
            cnt[c - 'a'] += 1;
        }

        for (int s = 0; s < (1<<n); s++) {
            int[] tmp = new int[26];
            for (int k = 0; k < n; k++) {
                if ((s & (1 << k)) == 0) continue;
                for (char c : words[k].toCharArray()) {
                    tmp[c - 'a'] += 1;
                }
            }
            res = Math.max(res, compare(cnt, tmp, score));
        }
        return res;
    }

    private int compare (int[] cnt, int [] tmp, int[] scores) {
        int ret = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] < tmp[i]) return 0;
            ret += tmp[i] * scores[i];
        }
        return ret;
    }

}
