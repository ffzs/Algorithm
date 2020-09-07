package topKFrequent;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/9/7 上午8:07
 */
public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.compute(num, (key, value)-> value = value == null? 1: value +1);
        }
        // 根据值排序
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(numMap::get));
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (heap.size() < k) heap.add(entry.getKey());
            else if (numMap.get(heap.peek()) < entry.getValue()) {
                heap.poll();
                heap.add(entry.getKey());
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}
