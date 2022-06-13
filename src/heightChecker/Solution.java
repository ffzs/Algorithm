package heightChecker;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/6/13 上午9:22
 */
public class Solution {

    public int heightChecker(int[] heights) {
//        int[] tmp = Arrays.copyOf(heights, heights.length);
//        Arrays.sort(tmp);
//        int res = 0;
//        for (int i = 0; i < heights.length; i++) {
//            if (heights[i] != tmp[i]) res += 1;
//        }
        return countSorted(heights);
    }

    private int countSorted(int[] heights){
        int[] cnt = new int[101];
        for (int height : heights) {
            cnt[height] += 1;
        }

        int res = 0, i = 0;
        for (int height : heights) {
            while (cnt[i] == 0) i += 1;
            if (i != height) res += 1;
            cnt[i] -= 1;
        }
        return res;
    }

}
