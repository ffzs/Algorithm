package maskPII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2023/4/1 上午8:41
 */
public class Solution {
    int diff = 'A' - 'a';
    public String maskPII(String s) {
        if (s.contains("@")) return transEmail(s);
        return transPhoneNumber(s);
    }

    private String transPhoneNumber (String s) {
        StringBuilder sb = new StringBuilder();
        char[] cs = new char[13];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') cs[j++] = c;
        }
        int len = j;
        j--;
        for (int i = 0; i < 4; i++) {
            sb.append(cs[j--]);
        }
        for (int i = 0; i <= j; i++) {
            if (i % 3 == 0) {
                sb.append('-');
            }
            sb.append('*');
        }
        if (len > 10) sb.append('+');
        return sb.reverse().toString();
    }

    private String transEmail (String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (s.charAt(i) != '@') i += 1;
        sb.append(lower(s.charAt(0)));
        sb.append("*****");
        sb.append(lower(s.charAt(i-1))).append('@');
        for (int j = i + 1; j < s.length(); j++) {
            sb.append(lower(s.charAt(j)));
        }
        return sb.toString();
    }

    private char lower (char c) {
        if (c >= 'A' && c <= 'Z') return (char)(c - diff);
        else return c;
    }
}
