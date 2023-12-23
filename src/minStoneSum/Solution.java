package minStoneSum;

import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2023/12/23 上午10:47
 */
public class Solution {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        int res = 0;
        for (int pile : piles) {
            pq.offer(pile);
            res += pile;
        }

        while (k > 0) {
            int v = pq.poll();
            pq.offer(v - v / 2);
            res -= v / 2;
            k--;
        }
        return res;
    }

}
