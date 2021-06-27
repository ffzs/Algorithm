package snakesAndLadders;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: ffzs
 * @Date: 2021/6/27 上午10:29
 */
public class Solution {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int end = n * n;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[end + 1];
        queue.offer(new int[]{1, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = cur[0] + i;
                if (next > end) break;
                int[] rc = id2rc(next, n);
                if (board[rc[0]][rc[1]] > 0) next = board[rc[0]][rc[1]];
                if (next == end) return cur[1] + 1;
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, cur[1] + 1});
                }
            }
        }
        return -1;
    }

    private int[] id2rc(int next, int n) {
        int r = (next - 1) / n, c = (next - 1) % n;
        return new int[]{n - 1 - r, r % 2 == 1 ? n - 1 - c : c};
    }
}
