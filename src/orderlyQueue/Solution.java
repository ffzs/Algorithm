package orderlyQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2022/8/3 上午8:15
 */
public class Solution {

    public String orderlyQueue(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        if (k == 1) {
            for (int i = 1; i < s.length(); i++) {
                sb.append(sb.charAt(0));
                sb.deleteCharAt(0);
                if (sb.toString().compareTo(s) < 0) s = sb.toString();
            }
            return s;
        }
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}
