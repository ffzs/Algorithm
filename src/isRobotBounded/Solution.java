package isRobotBounded;

/**
 * @author: ffzs
 * @Date: 2023/4/11 上午8:36
 */
public class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean isRobotBounded(String instructions) {
        char[] cs = instructions.toCharArray();
        int cnt = 0, x = 0, y = 0;
        for (char c : cs) {
            if (c == 'L') cnt += 1;
            else if (c == 'R') cnt -= 1;
            else {
                int idx = ((cnt % 4) + 4) % 4;
                int[] dir = dirs[idx];
                x += dir[0];
                y += dir[1];
                System.out.println(x + ":" + y);
            }
        }

        return cnt % 4 != 0 ||( x == 0 && y == 0);
    }

}
