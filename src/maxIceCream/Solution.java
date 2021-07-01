package maxIceCream;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2021/7/2 上午6:55
 */
public class Solution {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int cost : costs) {
            if (coins >= cost) coins-=cost;
            else break;
            res++;
        }
        return res;
    }

    public int maxIceCream2(int[] costs, int coins) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        for (int cost : costs) {
            if (cost + sum <= coins){
                queue.offer(-cost);
                sum += cost;
            }
            else if (!queue.isEmpty() && (-queue.peek()) > cost) {
                sum += queue.poll();
                sum += cost;
                queue.offer(-cost);
            }
        }
        return queue.size();
    }

}
