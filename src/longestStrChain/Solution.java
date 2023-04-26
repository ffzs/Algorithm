package longestStrChain;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/4/27 上午6:24
 */
public class Solution {

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int[] cnt = new int[n];

        int res = 0;
        String a, b;
        for (int i = 0; i < n; i++) {
            a = words[i];
            for (int j = i + 1; j < n; j++) {
                b = words[j];
                if (a.length() == b.length()) continue;
                else if (a.length() + 1 == b.length()) {
                    if (check(a, b)) cnt[j] = Math.max(cnt[j], cnt[i] + 1);
                }
                else break;
            }
            res = Math.max(res, cnt[i]);
        }
        return res + 1;
    }

    private boolean check (String a, String b) {
        int cnt = 0, j = 0;
        for (int i = 0; i < b.length() && j < a.length(); i++) {
            if (a.charAt(j) != b.charAt(i)) {
                if (cnt == 1) return false;
                cnt += 1;
            }
            else j += 1;
        }
        return true;
    }

}
