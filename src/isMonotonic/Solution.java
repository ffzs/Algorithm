package isMonotonic;

/**
 * @author: ffzs
 * @Date: 2021/2/28 上午8:19
 */
public class Solution {


    public boolean isMonotonic(int[] A) {
        int isMinus = 0, isPlus = 0;
        int n = A.length;

        if (n <= 2) return true;

        for (int i = 1; i < A.length; i++) {
            int cur = A[i] - A[i-1];
            if (cur < 0 && isMinus ==0) isMinus = 1;
            if (cur > 0 && isPlus ==0) isPlus = 1;
            if (isMinus*isPlus != 0) return false;
        }

        return true;
    }
}

class Test {
    public static void main(String[] args) {
        int[] A = {2,2,2,1,4,5};
        Solution solution = new Solution();
        System.out.println(solution.isMonotonic(A));
    }
}
