package CQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/30
 */
public class CQueue {
    Deque<Integer> s1;
    Deque<Integer> s2;

    public CQueue() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (!s2.isEmpty()) return s2.pop();
        while (!s1.isEmpty()) s2.push(s1.pop());
        if (!s2.isEmpty()) return s2.pop();
        else return -1;
    }
}
