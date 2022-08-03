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
        String res = s;
        if (k == 1) {
            for (int i = 1; i < s.length(); i++) {
                String tmp = s.substring(i) + s.substring(0, i);
                if (tmp.compareTo(res) < 0) res = tmp;
            }
            return res;
        }
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}
