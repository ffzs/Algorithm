package pickGifts;

import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2023/10/28 上午11:01
 */
public class Solution {

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int gift : gifts) {
            pq.offer(gift);
        }

        while (k-->0) {
            int v = pq.poll();
            pq.offer((int)Math.sqrt(v));
        }

        long res = 0;
        while (!pq.isEmpty()){
            res+=pq.poll();
        }

        return res;
    }

}
