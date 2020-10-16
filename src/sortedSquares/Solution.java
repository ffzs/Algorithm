package sortedSquares;

/**
 * @author: ffzs
 * @Date: 2020/10/16 上午7:36
 */
public class Solution {
    public int[] sortedSquares(int[] A) {
        int max = Math.max(-A[0], A[A.length-1]);
        int[] tmp = new int[max+1];

        for (int i : A) {
            if (i<0) tmp[-i]++;
            else tmp[i]++;
        }

        int[] res = new int[A.length];
        int index = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != 0){
                for (int j = 0; j < tmp[i]; j++) {
                    res[index++] = i*i;
                }
            }
        }
        return res;
    }
}
