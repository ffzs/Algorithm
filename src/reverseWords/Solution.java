package reverseWords;

/**
 * @author: ffzs
 * @Date: 2020/8/30 上午7:32
 */

public class Solution {
    public String reverseWords(String s) {
        char[] seq = s.toCharArray();
        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        for (char c : seq) {
            if (c == ' ') {
                res.append(tmp.reverse()).append(' ');
                tmp = new StringBuilder();
            }
            else tmp.append(c);
        }
        return res.append(tmp.reverse()).toString();
    }
}
