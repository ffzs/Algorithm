package MedianFinder;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2021/8/27 上午6:53
 */
public class MedianFinder {
    /** initialize your data structure here. */
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianFinder() {
        min = new PriorityQueue<>((a, b) -> (b - a));
        max = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    }

    public void addNum(int num) {
        if (min.isEmpty() || num <= min.peek()) {
            min.offer(num);
            if (min.size() - 1 > max.size()) max.offer(min.poll());
        }
        else {
            max.offer(num);
            if (max.size() > min.size()) min.offer(max.poll());
        }
    }

    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
        return min.peek();
    }

}
