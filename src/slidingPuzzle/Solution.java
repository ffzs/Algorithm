package slidingPuzzle;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/6/26 上午9:41
 */

class AStar{
    public static int[][] dist = {
            {0,1,2,1,2,3},
            {1,0,1,2,1,2},
            {2,1,0,3,2,1},
            {1,2,3,0,1,2},
            {2,1,2,1,0,1},
            {3,2,1,2,1,0}
    };

    public String status;
    public int f, g, h;

    public AStar(String status, int g) {
        this.status = status;
        this.g = g;
        this.h = getH(status);
        this.f = this.g + this.h;
    }

    private static int getH(String status) {
        int ret = 0;
        for (int i = 0; i < 6; i++) {
            int cur = status.charAt(i);
            if (cur != '0') {
                ret += dist[i][cur - '1'];
            }
        }
        return ret;
    }
}

public class Solution {

    int[][] neighbors = {{1,3}, {0,2,4}, {1,5}, {0,4}, {1,3,5}, {2,4}};
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();

        if (initial.equals("123450")) return 0;

        PriorityQueue<AStar> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.f));

        pq.offer(new AStar(initial, 0));

        Set<String> seen = new HashSet<>();
        seen.add(initial);

        while (!pq.isEmpty()) {
            AStar cur = pq.poll();
            for (String s : getNext(cur.status)) {
                if (!seen.contains(s)) {
                    if ("123450".equals(s)) return cur.g + 1;
                    pq.offer(new AStar(s, cur.g + 1));
                    seen.add(s);
                }
            }
        }
        return -1;
    }

    private List<String> getNext(String status){
        List<String> ret = new ArrayList<>();
        char[] cs = status.toCharArray();

        int x = status.indexOf('0');
        for(int y: neighbors[x]){
            swap(cs, x, y);
            ret.add(new String(cs));
            swap(cs, x, y);
        }
        return ret;
    }

    private void swap(char[] cs, int x, int y) {
        char tmp = cs[x];
        cs[x] = cs[y];
        cs[y] = tmp;
    }

}
