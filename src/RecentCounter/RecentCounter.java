package RecentCounter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2022/5/6 上午8:37
 */
public class RecentCounter {

    Deque<Integer> q;
    public RecentCounter() {
        q = new ArrayDeque<>();
    }

    public int ping(int t) {
        q.offer(t);
        while (q.peek() < t - 3000) q.poll();
        return q.size();
    }

}
