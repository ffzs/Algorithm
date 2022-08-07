package exclusiveTime;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/8/7 下午12:28
 */
public class Solution {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Deque<int[]> stack = new LinkedList<>();
        for (String log : logs) {
            int[] cur = parse(log);
            if (cur[1] == 0) {
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] += cur[2] - stack.peek()[2];
                    stack.peek()[2] = cur[2];
                }
                stack.push(cur);
            }
            else {
                int[] t = stack.pop();
                res[t[0]] += cur[2] - t[2] + 1;
                if (!stack.isEmpty()) stack.peek()[2] = cur[2] + 1;
            }
        }
        return res;
    }

    private int[] parse (String log) {
        int i = log.indexOf(':'), j = log.lastIndexOf(":");
        return new int[]{Integer.parseInt(log.substring(0, i)), log.substring(i+1, j).equals("start") ? 0:1, Integer.parseInt(log.substring(j+1))};
    }

}
