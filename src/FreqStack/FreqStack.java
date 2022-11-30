package FreqStack;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/11/30 下午3:47
 */
public class FreqStack {
    Map<Integer, Integer> freq;
    List<List<Integer>> stacks;
    public FreqStack() {
        stacks = new ArrayList<>();
        stacks.add(new ArrayList<>());
        freq = new HashMap<>();
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (stacks.size() == f) stacks.add(new ArrayList<>());
        stacks.get(f).add(val);
    }

    public int pop() {
        int maxFreq = stacks.size() - 1;
        List<Integer> cur = stacks.get(maxFreq);
        int val = cur.remove(cur.size() - 1);
        if (cur.isEmpty()) stacks.remove(maxFreq);
        freq.put(val, maxFreq - 1);
        return val;
    }
}
