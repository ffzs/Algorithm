package getNumberOfBacklogOrders;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2023/1/2 上午9:32
 */
public class Solution {
    static int MOD = (int)1e9 + 7;
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buys = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> sells = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int[] order : orders) {
            int price = order[0], amount = order[1], orderType = order[2];
            if (orderType == 0) {
                while (!sells.isEmpty() && sells.peek()[1]<=price && amount > 0) {
                    if (sells.peek()[0] > amount) {
                        sells.peek()[0] -= amount;
                        amount = 0;
                    }
                    else amount -= sells.poll()[0];

                }
                if (amount > 0) buys.offer(new int[]{amount, price});
            }
            else {
                while (!buys.isEmpty() && buys.peek()[1] >= price && amount > 0) {
                    if (buys.peek()[0] > amount) {
                        buys.peek()[0] -= amount;
                        amount = 0;
                    }
                    else amount -= buys.poll()[0];
                }
                if (amount > 0) sells.offer(new int[] {amount, price});
            }
        }
        int res = 0;
        while (!buys.isEmpty()) {
            res += buys.poll()[0];
            if (res >= MOD) res -= MOD;
        }
        while (!sells.isEmpty()) {
            res += sells.poll()[0];
            if (res >= MOD) res -= MOD;
        }
        return res;
    }

}
