package validMountainArray;

/**
 * @author: ffzs
 * @Date: 2020/11/3 上午6:18
 */
public class Solution {

    public boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        int i = 0;
        while (i+1 < A.length) {
            if (A[i+1] < A[i]) break;
            else if (A[i+1] == A[i]) return false;
            i++;
        }
        if (i == A.length -1 || i==0) return false;
        while (i+1 < A.length) {
            if (A[i+1] >= A[i]) return false;
            i++;
        }
        return true;
    }

}
