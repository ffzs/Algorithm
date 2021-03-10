package calculate2;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2021/3/11 上午7:08
 */
public class Solution {

    public int calculate(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        Deque<Integer> deque = new LinkedList<>();
        int res = 0;
        char sign = '+';
        int i = 0, num = 0;
        while (i < n) {
            if (cs[i] == ' ');
            else if (cs[i] >= '0' && cs[i] <= '9') {
                num = 0;
                while (i < n && cs[i] <= '9' && cs[i] >= '0') {
                    num = num*10 + cs[i] - '0';
                    i++;
                }
                i--;
                if (sign == '+') deque.push(num);
                else if (sign == '-') deque.push(-num);
                else if (sign == '*') deque.push(deque.pop() * num);
                else if (sign == '/') deque.push(deque.pop() / num);
            }
            else {
                sign = cs[i];
            }
            i++;
        }
        while (!deque.isEmpty()) {
            res += deque.pop();
        }
        return res;
    }

}
