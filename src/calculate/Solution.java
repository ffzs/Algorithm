package calculate;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2021/3/10 上午7:49
 */
public class Solution {

    public int calculate(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        Deque<Integer> deque = new LinkedList<>();

        int sign = 1;
        deque.push(sign);

        int i = 0, res = 0;
        while (i < n) {
            if (cs[i] == ' ') ;
            else if (cs[i] == '+') sign = deque.peek();
            else if (cs[i] == '-') sign = -deque.peek();
            else if (cs[i] == '(') deque.push(sign);
            else if (cs[i] == ')') deque.pop();
            else {
                long num = 0;
                while (i < n && cs[i] >= '0' && cs[i] <= '9') {
                    num = num*10 + cs[i] - '0';
                    i ++;
                }
                res += sign*num;
                i --;
            }
            i ++;
        }
        return res;
    }

}
