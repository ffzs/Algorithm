package findLength;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/1
 */
public class Solution4 {
    public static int findLength(int[] A, int[] B) {
        int res = 0;
        // 保证 A 短
        if (A.length > B.length) {
            int[] tmp = A;
            A = B;
            B = tmp;
        }

        int ia = A.length - 1, ib = 0 , len = 1;

        while (ib != B.length) {
            if (len > res) res = Math.max(matchLen(A, B, ia, ib, len), res);
            if (ib == 0 && ia != 0){
                ia --;
                len = A.length - ia;
            }
            else {
                ib++;
                len = Math.min(A.length, B.length-ib);
            }
        }
        return res;
    }

    private static int matchLen (int[] A, int[] B, int ai, int bi, int len) {
        int count = 0, ret = 0;
        for (int i = 0; i < len; i++) {
            if (A[ai + i] == B[bi + i]){
                count++;
                ret = Math.max(ret, count);
            }
            else count = 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        System.out.println(findLength(A, B));
    }
}
