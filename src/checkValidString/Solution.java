package checkValidString;

import java.nio.file.Files;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2021/9/12 上午7:36
 */

public class Solution {

    public boolean checkValidString(String s) {
        Deque<Integer> left = new LinkedList<>();
        Deque<Integer> star = new LinkedList<>();

        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') left.push(i);
            else if (cs[i] == '*') star.push(i);
            else if (left.isEmpty() && star.isEmpty()) return false;
            else {
                if (!left.isEmpty()) {
                    left.pop();
                }
                else star.pop();
            }
        }


        while (!left.isEmpty() && !star.isEmpty()) {
            int leftIndex = left.pop();
            int starIndex = star.pop();
            if (leftIndex > starIndex) {
                return false;
            }
        }
        return left.isEmpty();
    }

    public boolean checkValidString2(String s) {
        int min = 0, max = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                min = Math.max(min - 1, 0);
                max--;
                if (max < 0) return false;
            } else {
                min = Math.max(min - 1, 0);
                max++;
            }
        }
        return min == 0;
    }
}
