package longestMountain;

/**
 * @author: ffzs
 * @Date: 2020/10/25 上午6:13
 */
public class Solution {

    public static int longestMountain(int[] A) {
        int i = 0, max = 0;
        while (i < A.length) {
            int up = 0, down = 0;
            while (i < A.length - 2 && A[i] - A[i + 1] < 0) {
                i++;
                up++;
            }
            while (i + 1 < A.length && A[i + 1] - A[i] < 0) {
                i++;
                down++;
            }
            if (up > 0 && down > 0) max = Math.max(max, up + down + 1);
            if (down > 0 || up > 0) i--;
            i++;
        }
        return max;
    }
}

class Test {
    public static void main(String[] args) {
//        int[] A = {2,1,4,7,3,2,5};
        int[] A = {40, 51, 29, 19, 50, 25};
        System.out.println(Solution.longestMountain(A));
    }
}
