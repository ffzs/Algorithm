package medianSlidingWindow;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2021/2/3 下午7:52
 */

class DualHeap {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private Map<Integer, Integer> delayed;

    private boolean isOdd;
    private int smallSize, largeSize;

    public DualHeap(int k) {
        this.isOdd = (k&1) == 1;
        this.small = new PriorityQueue<>(Comparator.reverseOrder());
        this.large = new PriorityQueue<>(Comparator.naturalOrder());
        this.delayed = new HashMap<>();
        this.smallSize = 0;
        this.largeSize = 0;
    }

    public double getMedian(){
        return isOdd? small.peek() : ((long)small.peek() + large.peek()) / 2D;
    }

    public void insert(int num) {
        if (!delayed.containsKey(num)) delayed.put(num, 0);
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        }
        else {
            large.offer(num);
            largeSize++;
        }
        makeBalance();
    }

    public void erase(int num) {

        if (num <= small.peek()) {
            smallSize--;
            if (num == small.peek()) {
                small.poll();
                prune(small);
            }
            else delayed.put(num, delayed.get(num) + 1);
        }
        else {
            largeSize --;
            if (num == large.peek()) {
                large.poll();
                prune(large);
            }
            else delayed.put(num, delayed.get(num) + 1);
        }
        makeBalance();
    }

    private void makeBalance() {
        if (smallSize > largeSize + 1) {
            large.offer(small.poll());
            smallSize--; largeSize++;
            prune(small);
        }
        else if (smallSize < largeSize) {
            small.offer(large.poll());
            smallSize++; largeSize--;
            prune(large);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.get(num) > 0) {
                delayed.put(num, delayed.get(num) - 1);
                heap.poll();
            }
            else break;
        }
    }
}

public class Solution2 {
    public double[] medianSlidingWindow(int[] nums, int k) {

        DualHeap dh = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dh.insert(nums[i]);
        }

        double[] res = new double[nums.length - k + 1];

        res[0] = dh.getMedian();

        for (int i = k; i < nums.length; i++) {
            dh.insert(nums[i]);
            dh.erase(nums[i-k]);
            res[i - k + 1] = dh.getMedian();
        }

        return res;
    }
}
