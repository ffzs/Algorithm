package findJudge;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/12/19 上午8:01
 */
public class Solution {

    public int findJudge(int n, int[][] trust) {
        if (n == 1) return 1;
        int[] cnt = new int[n + 1];
        for (int[] ints : trust) {
            cnt[ints[0]]--;
            cnt[ints[1]]++;
        }
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i] == n - 1) return i;
        }
        return -1;
    }

}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] trust = {{1,2}, {2,3}};
        System.out.println(s.findJudge(3, trust));
    }
}
