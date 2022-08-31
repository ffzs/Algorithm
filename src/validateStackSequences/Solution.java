package validateStackSequences;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2022/8/31 上午8:48
 */

public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        Deque<Integer> stack = new LinkedList<>();
        int n = popped.length, i = 0, j = 0;
        for (; i < n; i++) {
            int cur = popped[i];
            if (!stack.isEmpty() && cur == stack.peek()) stack.pop();
            else {
                if (j == n) return false;
                while (j < n && pushed[j] != cur) stack.push(pushed[j++]);
                if (j < n && pushed[j] == cur) j += 1;
            }
        }
        return stack.isEmpty();
    }

}
