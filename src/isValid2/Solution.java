package isValid2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2022/5/2 上午8:48
 */
public class Solution {

    public boolean isValid(String code) {
        Deque<String> stack = new LinkedList<>();

        char[] cs = code.toCharArray();
        int n = cs.length, i = 0;
        while (i < n) {
            if (cs[i] == '<') {
                if (i + 1 >= n) return false;
                if (cs[i + 1] == '!') {
                    if (i + 11 >= n) return false;
                    String cdata = code.substring(i + 2, i + 9);
                    if (!cdata.equals("[CDATA[")) return false;
                    int j = code.indexOf("]]>", i);
                    if (j == -1) return false;
                    i = j + 1;
                }
                else if (cs[i + 1] == '/') {
                    int j = code.indexOf('>', i);
                    if (j == -1) return false;
                    String tagName= code.substring(i + 2, j);
                    if (stack.isEmpty() || !stack.pop().equals(tagName)) return false;
                    i = j + 1;
                    if (stack.isEmpty() && i != n) return false;
                }
                else {
                    int j = code.indexOf('>',i);
                    if (j == -1) return false;
                    String tagName = code.substring(i + 1, j);
                    if (!isTagName(tagName)) return false;
                    stack.push(tagName);
                    i = j + 1;
                }
            }
            else {
                if (stack.isEmpty()) return false;
                ++i;
            }
        }
        return stack.isEmpty();
    }

    private boolean isTagName (String s) {
        if (s.length() > 9 || s.length() < 1) return false;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c > 'Z' || c < 'A') return false;
        }
        return true;
    }

}
