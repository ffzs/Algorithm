package modifyString;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/1/5 上午8:11
 */
public class Solution {

    public String modifyString(String s) {
        char[] cs = s.toCharArray();
        if (cs[0] == '?') {
            if (cs.length == 1) cs[0] = 'a';
            else cs[0] = getOne('?', cs[1]);
        }
        for (int i = 1; i < cs.length - 1; i++) {
            if (cs[i] == '?') cs[i] = getOne(cs[i-1], cs[i + 1]);
        }

        if (cs[cs.length-1] == '?') cs[cs.length-1] = getOne(cs[cs.length-2], '?');
        return new String(cs);
    }

    private char getOne(int pre, int suf) {
        for (int i = 0; i < 26; i++) {
            if (i + 'a' != pre && i + 'a' != suf) return (char)(i + 'a');
        }
        return '?';
    }

}
