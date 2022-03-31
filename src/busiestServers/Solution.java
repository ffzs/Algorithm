package busiestServers;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/3/30 上午7:48
 */
public class Solution {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n = arrival.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        TreeSet<Integer> set = new TreeSet<>();
        int[] cnt = new int[k];

        int time, max = 0;

        for (int i = 0; i < k && i < n; ++i) {
            pq.add(new int[]{arrival[i] + load[i], i});
            max = Math.max(max, ++cnt[i]);
        }

        for (int i = k; i < n; i++) {
            time = arrival[i];
            while (!pq.isEmpty() && pq.peek()[0] <= time) {
                set.add(pq.poll()[1]);
            }
            Integer idx = set.ceiling(i % k);
            if (idx == null) idx = set.pollFirst();
            else set.remove(idx);
            if (idx == null) continue;
            pq.add(new int[]{time + load[i], idx});
            max = Math.max(max, ++cnt[idx]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == max) res.add(i);
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arrival = {1,3,4,5,6,11,12,13,15,19,20,21,23,25,31,32};
        int[] load = {9,16,14,1,5,15,6,10,1,1,7,5,11,4,4,6};
//        int[] arrival = {1,3,4,5,6,11,12,13,15,19,20,21,23,25,31,32};
//        int[] load = {9,16,14,1,5,15,6,10,1,1,7,5,11,4,4,6};
        System.out.println(s.busiestServers(7, arrival, load));
    }
}
