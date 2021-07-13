package getSkyline;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/7/13 上午7:51
 */
public class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Integer> gaps = new ArrayList<>();
        for (int[] building : buildings) {
            gaps.add(building[0]);
            gaps.add(building[1]);
        }

        gaps.sort(Comparator.naturalOrder());

        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int n = buildings.length;
        int idx = 0;
        for (Integer gap : gaps) {
            while (idx < n && buildings[idx][0] <= gap) {
                pq.offer(new int[]{buildings[idx][1], buildings[idx][2]});
                idx++;
            }
            while (!pq.isEmpty() && pq.peek()[0] <= gap) pq.poll();

            int max = pq.isEmpty() ? 0:pq.peek()[1];

            if (res.size() == 0 || max != res.get(res.size()-1).get(1)) res.add(Arrays.asList(gap, max));
        }
        return res;
    }

}
