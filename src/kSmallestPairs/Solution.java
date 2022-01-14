package kSmallestPairs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 * @author: ffzs
 * @Date: 2022/1/14 上午7:49
 */

public class Solution {
    boolean flag = true;
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length > nums2.length) {
            flag = false;
            return kSmallestPairs(nums2, nums1, k);
        }

        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length, n = nums2.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        for (int i = 0; i < Math.min(m, k); i++) {
            pq.add(new int[]{i, 0});
        }

        while (res.size() < k && !pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0], j = cur[1];
            res.add(flag ? List.of(nums1[i], nums2[j]) : List.of(nums2[j], nums1[i]));
            if (j + 1 < n) pq.add(new int[] {i, j + 1});
        }
        return res;
    }

}
