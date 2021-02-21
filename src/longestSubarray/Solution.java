package longestSubarray;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2021/2/21 下午7:39
 */
public class Solution {

    public int longestSubarray(int[] nums, int limit) {

        int n = nums.length;

        Deque<Integer> minQ = new LinkedList<>();
        Deque<Integer> maxQ = new LinkedList<>();
        int res = 0;
        int left = 0, right = 0;

        while (right < n) {
            int cur = nums[right];
            while (!minQ.isEmpty() && minQ.peekLast() > cur) minQ.pollLast();
            minQ.offerLast(cur);
            while (!maxQ.isEmpty() && maxQ.peekLast() < cur) maxQ.pollLast();
            maxQ.offerLast(cur);

            while (!minQ.isEmpty() && !maxQ.isEmpty() && (maxQ.peekFirst() - minQ.peekFirst()) > limit) {
                if (nums[left] == minQ.peekFirst()) minQ.pollFirst();
                if (nums[left] == maxQ.peekFirst()) maxQ.pollFirst();
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
