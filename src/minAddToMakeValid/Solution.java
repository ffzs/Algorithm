package minAddToMakeValid;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2022/10/4 下午3:27
 */
public class Solution {

    public int minAddToMakeValid(String s) {
        char[] cs = s.toCharArray();
        int res = 0, cnt = 0;
        for (char c : cs) {
            if (c == '(') {
                cnt += 1;
            } else {
                if (cnt > 0) cnt -= 1;
                else res += 1;
            }
        }
        return res;
    }

}
