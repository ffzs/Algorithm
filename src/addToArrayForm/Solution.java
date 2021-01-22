package addToArrayForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/1/22 上午8:12
 */
public class Solution {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int re = 0, i = A.length-1;
        LinkedList<Integer> res = new LinkedList<>();
        while (i >= 0 || K != 0 || re != 0) {
            int remain = K % 10;
            K /= 10;
            int num = i >= 0 ? remain + A[i] + re : remain + re;
            res.addFirst(num % 10);
            re = num / 10;
            i--;
        }

        return res;
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1,2,0,0};
        System.out.println(solution.addToArrayForm(A, 34));
    }
}
