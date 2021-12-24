package eatenApples;

import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2021/12/24 上午7:59
 */
public class Solution {

    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int res = 0, i = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        while (i < n || !pq.isEmpty()) {
            if (i < n && apples[i] > 0) pq.add(new int[] {i + days[i] - 1, apples[i]});
            while (!pq.isEmpty() && pq.peek()[0] < i) pq.poll();

            if (!pq.isEmpty()) {
                int[] cur = pq.peek();
                if (--cur[1] == 0) pq.poll();
                res++;
            }
            i++;
        }
        return res;
    }

}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] apples = {2, 1, 10}, days = {2, 10, 1};
        System.out.println(s.eatenApples(apples, days));
    }
}
