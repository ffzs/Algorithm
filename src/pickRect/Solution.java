package pickRect;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: ffzs
 * @Date: 2022/6/9 上午9:03
 */
public class Solution {
    int[][] rects;
    Random r = new Random();
    int[] area;
    public Solution(int[][] rects) {
        this.rects = rects;
        area = new int[rects.length + 1];
        for (int i = 0; i < area.length - 1; i++) {
            int a = rects[i][0], b = rects[i][1], x = rects[i][2], y = rects[i][3];
            area[i + 1] = area[i] + (x - a + 1) * (y - b + 1);
        }
    }

    public int[] pick() {
        int t = r.nextInt(area[area.length - 1]);
        int idx = search(t+1) - 1;
        int a = rects[idx][0], b = rects[idx][1], x = rects[idx][2], y = rects[idx][3];
        return new int[]{a + r.nextInt(x-a+1), b + r.nextInt(y-b+1)};
    }

    private int search (int t) {
        int l = 0, r = area.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (area[mid] == t) return mid;
            else if (area[mid] > t) r = mid - 1;
            else l = mid + 1;
        }
        return l;
    }
}
