package magicTower;

import java.util.PriorityQueue;

/**
 * @author: ffzs
 * @Date: 2024/2/6 下午9:59
 */
public class Solution {

    public int magicTower(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int res = 0;
        long hp = 1, delay = 0;
        for (int num : nums) {
            if (num < 0) {
                queue.offer(num);
            }
            hp += num;

            if (hp <= 0) {
                res += 1;
                int curr = queue.poll();
                delay += curr;
                hp -= curr;
            }
        }
        hp += delay;
        return hp <= 0 ? -1 : res;
    }

}
