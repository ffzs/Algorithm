package removeStones;

/**
 * @author: ffzs
 * @Date: 2021/1/15 下午7:28
 */
public class Solution {

    public int removeStones(int[][] stones) {
        int maxX = 0, maxY = 0;
        for (int[] stone : stones) {
            maxX = Math.max(stone[0], maxX);
            maxY = Math.max(stone[1], maxY);
        }

        int[] father = new int[maxX + maxY + 2];
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }

        for (int[] stone : stones) {
            int y = stone[1] + maxX + 1;
            int f1 = find(father, stone[0]);
            int f2 = find(father, y);
            if (f1 != f2) union(father, stone[0], y);
        }

        boolean[] tmp = new boolean[maxX + maxY + 2];
        int counter = 0;

        for (int[] stone : stones) {
            int f = find(father, stone[0]);
            if (!tmp[f]) {
                tmp[f] = true;
                counter++;
            }
        }

        return stones.length - counter;
    }

    private int find (int[] f, int i) {
        if (f[i] != i) f[i] = find(f, f[i]);
        return f[i];
    }

    private void union (int[] f, int i, int j) {
        f[find(f, j)] = find(f, i);
    }

}
