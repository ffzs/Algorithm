package successfulPairs;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/11/10 上午9:53
 */
public class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            res[i] = bSearch(success, potions, spells[i]);
        }
        return res;
    }

    private int bSearch (long t, int[] arr, int v){
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if ((long)arr[mid] * v >= t) r = mid;
            else l = mid + 1;
        }
        if ((long)arr[r] * v >= t) return arr.length - r;
        return 0;
    }

}
