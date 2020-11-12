package sortArrayByParityII;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2020/11/12 下午3:49
 */
public class Solution {

    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1;
        int[] res = new int[A.length];
        for (int k : A) {
            if ((k & 1)==1) {
                res[j] = k;
                j += 2;
            }
            else{
                res[i] = k;
                i += 2;
            }
        }
        return res;
    }
}

class Test{
    public static void main(String[] args) {
        int[] A = {2,3,1,1,4,0,0,4,3,3};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArrayByParityII(A)));
    }
}
