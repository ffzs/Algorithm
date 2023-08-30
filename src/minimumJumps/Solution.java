package minimumJumps;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2023/8/30 上午7:38
 */
public class Solution {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i : forbidden) {
            set.add(i);
            max = Math.max(max, i);
        }

        int top = Math.max(max + a + b, b + x);
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 1, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int p = cur[0], dir = cur[1],step = cur[2];
            if (p == x) return step;

            int pre = p + a;
            if (pre <= top && !set.contains(pre) && !visited.contains(pre)) {
                visited.add(pre);
                q.offer(new int[]{pre, 1, step+1});
            }

            if (dir == 1) {
                int back = p - b;
                if (back >= 0 && !set.contains(back) && !visited.contains(back)) {
                    visited.add(back);
                    q.offer(new int[]{back, -1, step+1});
                }
            }
        }
        return -1;

    }
}
