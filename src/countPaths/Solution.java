package countPaths;


import java.util.*;

/**
 * @author: ffzs
 * @Date: 2024/3/5 下午10:02
 */
class Pair{
    Long key;
    Integer value;

    public Pair(Long key, Integer value) {
        this.key = key;
        this.value = value;
    }
}
public class Solution {
    private final static int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] road : roads) {
            int x = road[0], y = road[1], d = road[2];
            g[x].add(new int[]{y, d});
            g[y].add(new int[]{x, d});
        }

        long[] dis = new long[n];
        Arrays.fill(dis, 1, n, Long.MAX_VALUE);
        int[] f = new int[n];
        f[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(e->e.key));
        pq.offer(new Pair(0L, 0));

        while (true) {
            Pair pair = pq.poll();
            long dx = pair.key;
            int x = pair.value;
            if (x == n - 1) {
                return f[n-1];
            }
            if (dx > dis[x]) {
                continue;
            }

            for (int[] e : g[x]) {
                int y = e[0];
                long newDis = dx + e[1];
                if (newDis < dis[y]) {
                    dis[y] = newDis;
                    f[y] = f[x];
                    pq.offer(new Pair(newDis, y));
                }
                else if (newDis == dis[y]){
                    f[y] = (f[y] + f[x]) % MOD;
                }
            }
        }
    }

}
