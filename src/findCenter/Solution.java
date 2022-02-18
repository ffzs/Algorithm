package findCenter;

/**
 * @author: ffzs
 * @Date: 2022/2/18 上午9:22
 */
public class Solution {

    public int findCenter(int[][] edges) {
        for (int i : edges[0]) {
            for (int j : edges[1]) {
                if (i == j) return i;
            }
        }
        return -1;
    }

}
