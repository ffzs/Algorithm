package removeKdigits;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2020/11/15 上午11:52
 */
public class Solution2 {

    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        char[] cs = num.toCharArray();
        int n = cs.length -k ;
        for (char c : cs) {
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                deque.removeLast();
                k--;
            }
            deque.addLast(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char it = deque.pollFirst();
            if (!(sb.length()==0 && it == '0')) sb.append(it);
        }
        return sb.length()==0 ? "0":sb.toString();
    }
}
