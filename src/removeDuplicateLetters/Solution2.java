package removeDuplicateLetters;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/12/20 上午11:50
 */
public class Solution2 {

    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] counter = new int[26];
        boolean[] pick = new boolean[26];

        for (char c : chars) counter[c-'a']++;
        int len = 0;

        for (int i : counter) {
            if (i > 0) len++;
        }

        char[] res = new char[len];
        int idx = 0;

        for (char cur : chars) {
            if (!pick[cur - 'a']) {
                while (idx > 0 && res[idx - 1] > cur) {
                    if (counter[res[idx - 1] - 'a'] > 0) {
                        pick[res[idx - 1] - 'a'] = false;
                        idx--;
                    } else {
                        break;
                    }
                }
                pick[cur - 'a'] = true;
                res[idx++] = cur;
            }
            counter[cur - 'a']--;
        }
        return new String(res);
    }
}
