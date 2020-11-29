package largestPerimeter;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/11/29 下午3:33
 */
public class Solution {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i-2] + A[i-1] > A[i]) return A[i-1] + A[i-2] + A[i];
        }
        return 0;
    }
}
