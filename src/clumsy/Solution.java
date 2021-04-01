package clumsy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2021/4/1 上午8:35
 */
public class Solution {

    public int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();

        stack.push(N);

        for (int i = 0; i < N - 1; i++) {
            int cur = N-i-1;
            switch (i%4) {
                case 0:
                    stack.push(stack.pop()*cur);
                    break;
                case 1:
                    stack.push(stack.pop()/cur);
                    break;
                case 3:
                    stack.push(-cur);
                    break;
                default:
                    stack.push(cur);
                    break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
