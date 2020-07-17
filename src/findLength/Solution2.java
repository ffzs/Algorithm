package findLength;

import java.util.*;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/1
 */
public class Solution2 {
    public static int findLength(int[] A, int[] B) {
        if (A.length > B.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }
        Map<String, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(B[B.length-1]);
        for (int i = 0; i < B.length-1; i++) {
            set.add(B[i]);
            String m = (char) B[i] + String.valueOf((char)B[i+1]);
            if (!map.containsKey(m)) {
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                map.put(m, lst);
            }
            else {
                map.get(m).add(i);
            }
        }
        int res = set.contains(A[A.length-1])? 1: 0;
        for (int i = 0; i < A.length-1; i++) {
            if (res == 0 && set.contains(A[i])) res = 1;
            String m = (char) A[i] + String.valueOf((char)A[i+1]);
            if (map.containsKey(m) && i+res < A.length) {
                if (i != 0 && A[i-1] == A[i]) continue;
                for (Integer it : map.get(m)) {
                    res = Math.max(res, matchLen(A, B, i, it));
                }
            }
        }
        return res;
    }

    private static int matchLen (int[] A, int[] B, int sa, int sb) {
        int len = 2;
        int i = sa + 2, j = sb + 2;
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
