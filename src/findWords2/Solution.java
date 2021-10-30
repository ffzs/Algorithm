package findWords2;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/10/31 上午7:19
 */
public class Solution {
    static char[] first = "qwertyuiop".toCharArray();
    static char[] second = "asdfghjkl".toCharArray();
    static char[] third = "zxcvbnm".toCharArray();
    static int[] loc = new int[26];
    static {
        for (char c : first) loc[c-'a'] = 1;
        for (char c : second) loc[c-'a'] = 2;
        for (char c : third) loc[c-'a'] = 3;
    }
    public String[] findWords(String[] words) {
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            if (!check(words[i])) {
                words[i] = "";
                cnt ++;
            }
        }
        String[] res = new String[words.length-cnt];
        for (int i = 0, j = 0; i < words.length; i++) {
            if (!words[i].equals("")) res[j++] = words[i];
        }
        return res;
    }

    private boolean check (String s) {
        char[] cs = s.toLowerCase().toCharArray();
        int pre = loc[cs[0]-'a'];
        for (int i = 1; i < cs.length; i++) {
            int cur = loc[cs[i] - 'a'];
            if (cur != pre) return false;
            pre = cur;
        }
        return true;
    }

}
