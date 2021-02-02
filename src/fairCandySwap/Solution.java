package fairCandySwap;

/**
 * @author: ffzs
 * @Date: 2021/2/2 上午9:10
 */
public class Solution {

    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;
        boolean[] set = new boolean[100001];
        for (int i : A) {
            sa += i;
            set[i] = true;
        }

        for (int i : B) {
            sb += i;
        }

        int gap = (sa - sb) /2;
        for (int i : B) {
            int need = i + gap;
            if (need >=0 && need <= 100000 && set[need]) return new int[]{need, i};
        }

        return new int[2];
    }

}
