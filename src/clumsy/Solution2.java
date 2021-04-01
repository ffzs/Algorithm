package clumsy;

/**
 * @author: ffzs
 * @Date: 2021/4/1 上午8:51
 */
public class Solution2 {
    public int clumsy(int N) {
        if (N<=2) return N;
        else if (N<=4) return N + 3;
        else {
            int[] tmp = {0, 1, 1, -2};
            return N+1+tmp[N%4];
        }
    }
}
