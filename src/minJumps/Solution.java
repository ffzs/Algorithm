package minJumps;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/1/21 上午8:19
 */
public class Solution {

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        boolean[] step = new boolean[n];

        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            if (i > 0 && i < n - 1 && arr[i-1] == cur && arr[i+1] == cur) {
                step[i] = true;
                continue;
            }
            if (!map.containsKey(arr[i])) map.put(cur, new ArrayList<>());
            map.get(cur).add(i);
        }


        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        step[0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int idx = cur[0], cnt = cur[1];

            if (idx == n - 1) return cnt;

            int v = arr[idx];
            ++ cnt;

            if (map.containsKey(v)) {
                for (int i : map.get(v)) {
                    if (!step[i]) {
                        step[i] = true;
                        q.offer(new int[]{i, cnt});
                    }
                }
                map.remove(v);
            }
            if (idx + 1 < n && !step[idx+1]) {
                step[idx + 1] = true;
                q.offer(new int[]{idx +1, cnt});
            }
            if (idx - 1 >= 0 && !step[idx-1]) {
                step[idx - 1] = true;
                q.offer(new int[]{idx - 1, cnt});
            }
        }
        return -1;
    }

}
