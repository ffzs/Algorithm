package KthLargest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2021/2/11 上午8:47
 */
public class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>(Comparator.naturalOrder());
        if (nums.length > 0) {
            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= Math.max(nums.length - k, 0); i--) {
                pq.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (pq.size() == 0 || pq.size() < k) {
            pq.offer(val);
        }
        else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }
        return pq.peek();
    }
}
