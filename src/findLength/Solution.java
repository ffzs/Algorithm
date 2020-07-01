package findLength;

import java.util.*;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/1
 */
public class Solution {
    public static int findLength(int[] A, int[] B) {
        int res = 0;
        if (A.length > B.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            if (!map.containsKey(B[i])) {
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                map.put(B[i], lst);
            }
            else {
                map.get(B[i]).add(i);
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i]) && i+res < A.length) {
                for (Integer it : map.get(A[i])) {
                    res = Math.max(res, matchLen(A, B, i, it));
                }
            }
        }
        return res;
    }

    private static int matchLen (int[] A, int[] B, int sa, int sb) {
        int len = 1;
        int i = sa + 1, j = sb + 1;
        while (i < A.length && j < B.length) {
            if (A[i++] == B[j++]) {
                len ++;
            }
            else break;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
//        System.out.println(matchLen(A, B, 0, 1));
        System.out.println(findLength(A, B));
    }
}
