package MKAverage;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author: ffzs
 * @Date: 2023/1/18 下午6:35
 */
public class MKAverage {
    Queue<Integer> queue = new LinkedList<>();
    TreeMap<Integer, Integer> top = new TreeMap<>(), mid = new TreeMap<>(), low = new TreeMap<>();
    int tSize=0, mSize=0, lSize=0, m, k;
    long sum = 0;
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        queue.offer(num);
        if (queue.size() <= m) {
            mid.put(num, mid.getOrDefault(num, 0) + 1);
            mSize += 1;
            sum += num;
            if (queue.size() == m) {
                while (lSize < k) {
                    int first = mid.firstKey();
                    low.put(first, low.getOrDefault(first, 0) + 1);
                    lSize+=1;
                    sum -= first;
                    mid.put(first, mid.get(first)-1);
                    if (mid.get(first) == 0) mid.remove(first);
                    mSize-=1;
                }
                while (tSize < k) {
                    int last = mid.lastKey();
                    top.put(last, top.getOrDefault(last, 0) + 1);
                    tSize+=1;
                    sum -= last;
                    mid.put(last, mid.get(last)-1);
                    if (mid.get(last) == 0) mid.remove(last);
                    mSize-=1;
                }
            }
            return;
        }

        if (num < low.lastKey()) {
            low.put(num, low.getOrDefault(num, 0) + 1);
            int last = low.lastKey();
            mid.put(last, mid.getOrDefault(last, 0) + 1);
            mSize+=1;
            sum += last;
            low.put(last, low.get(last) - 1);
            if (low.get(last) == 0) low.remove(last);
        }
        else if (num > top.firstKey()) {
            top.put(num, top.getOrDefault(num, 0) + 1);
            int first = top.firstKey();
            mid.put(first, mid.getOrDefault(first, 0) - 1);
            mSize+=1;
            sum += first;
            top.put(first, top.get(first) - 1);
            if (top.get(first) == 0) top.remove(first);
        }
        else {
            mid.put(num, mid.getOrDefault(num, 0) + 1);
            mSize += 1;
            sum += num;
        }
        int out = queue.poll();
        if (low.containsKey(out)) {
            low.put(out, low.get(out) - 1);
            if (low.get(out) == 0) low.remove(out);
            int first = mid.firstKey();
            low.put(first, low.getOrDefault(first, 0) + 1);
            sum -= first;
            mid.put(first, mid.get(first) - 1);
            if (mid.get(first) == 0) mid.remove(first);
            mSize-=1;
        }
        else if (top.containsKey(out)) {
            top.put(out, top.get(out) - 1);
            if (top.get(out) == 0) top.remove(out);
            int last = mid.lastKey();
            top.put(last, top.getOrDefault(last, 0) + 1);
            mid.put(last, mid.get(last) - 1);
            if (mid.get(last) == 0) mid.remove(last);
            sum -= last;
            mSize -=1;
        }
        else {
            mid.put(out, mid.get(out) - 1);
            if (mid.get(out) == 0) mid.remove(out);
            sum -= out;
            mSize-=1;
        }
    }

    public int calculateMKAverage() {
        if (queue.size() < m) return -1;
        return (int)(sum / (m-2*k));
    }

}
