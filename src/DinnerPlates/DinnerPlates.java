package DinnerPlates;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2023/4/28 上午9:08
 */
public class DinnerPlates {
    List<int[]> stacks;
    int[] cnt;
    int idx, capacity;
    PriorityQueue<Integer> pq;
    public DinnerPlates(int capacity) {
        stacks = new ArrayList<>();
        idx = 0;
        cnt = new int[100010];
        this.capacity = capacity;
        stacks.add(new int[capacity]);
        pq = new PriorityQueue<>();
    }

    public void push(int val) {
        if (!pq.isEmpty()) {
            while (idx > 0 && cnt[idx] == 0) idx--;
            if (pq.peek() >= idx) {
                pq.clear();
            }
            else {
                int cur = pq.peek();
                stacks.get(cur)[cnt[cur]++] = val;
                while (!pq.isEmpty() && cnt[pq.peek()] == capacity) {
                    pq.poll();
                }
                return;
            }
        }

        if (idx == -1 || cnt[idx] == capacity) {
            stacks.add(new int[capacity]);
            idx += 1;
        }
        stacks.get(idx)[cnt[idx]++] = val;

    }

    public int pop() {
        if (stacks.isEmpty()) return -1;
        int ret = stacks.get(idx)[--cnt[idx]];
        while (idx >= 0 && cnt[idx] == 0) {
            stacks.remove(idx--);
        }
        return ret;
    }

    public int popAtStack(int index) {
        if (idx == index) return pop();
        if (stacks.size() < index) return -1;
        if (cnt[index] == 0) return -1;
        pq.offer(index);
        return stacks.get(index)[--cnt[index]];
    }

}
