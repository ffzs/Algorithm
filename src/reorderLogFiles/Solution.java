package reorderLogFiles;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/5/3 上午8:37
 */
public class Solution {
    private boolean isDig (char c) {
        return c >= '0' && c <= '9';
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            int ai = a.indexOf(' '), bi = b.indexOf(' ');
            if (isDig(a.charAt(ai + 1))) {
                if (isDig(b.charAt(bi + 1))) return 0;
                else return 1;
            }
            else {
                if (isDig(b.charAt(bi + 1))) return -1;
                else {
                    String subA = a.substring(ai + 1);
                    String subB = b.substring(bi + 1);
                    if (subA.equals(subB)) return a.compareTo(b);
                    return subA.compareTo(subB);
                }
            }
        });

        return logs;
    }
}
