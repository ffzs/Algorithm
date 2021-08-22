package escapeGhosts;

/**
 * @author: ffzs
 * @Date: 2021/8/22 上午9:01
 */

public class Solution {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int myWay = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int x = ghost[0], y = ghost[1];
            if (Math.abs(target[0] - x) + Math.abs(target[1] - y) <= myWay) return false;
        }
        return true;
    }

}
