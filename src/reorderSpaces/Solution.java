package reorderSpaces;

/**
 * @author: ffzs
 * @Date: 2022/9/7 上午8:36
 */
public class Solution {

    public String reorderSpaces(String text) {
        char[] cs = text.toCharArray();
        int blanks = 0, words = 0, n = cs.length;

        for (int i = 0; i < n; i++) {
            if (cs[i] == ' ') {
                blanks += 1;
            }
            else if (i == 0 || cs[i - 1] == ' ') words += 1;
        }
        int a, b;
        if (words == 1) {
            a = blanks;
            b = blanks;
        }
        else {a = blanks / (words - 1); b = blanks % (words - 1);}
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (cs[i] != ' ') {
                if (i != 0 && res.length() != 0 && cs[i-1] == ' ') {
                    for (int j = 0; j < a; j++) {
                        res.append(' ');
                    }
                }
                res.append(cs[i]);
            }
        }
        for (int i = 0; i < b; i++) {
            res.append(' ');
        }
        return res.toString();
    }
}
