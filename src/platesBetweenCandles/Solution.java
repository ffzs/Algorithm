package platesBetweenCandles;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/3/8 上午8:18
 */
public class Solution {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int[] cnt = new int[n], left = new int[n], right = new int[n];
        for (int i = 0, sum = 0; i < n; i++) {
            if (cs[i] == '*') ++sum;
            cnt[i] = sum;
        }

        for (int i = 0, l = -1; i < n; i++) {
            if (cs[i] == '|') {
                l = i;
            }
            left[i] = l;
        }

        for (int i = n-1, r = -1; i >= 0; i--) {
            if (cs[i] == '|') {
                r = i;
            }
            right[i] = r;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = right[queries[i][0]], r = left[queries[i][1]];
            if (l == -1 || r == -1 || l >= r) res[i] = 0;
            else res[i] = cnt[left[queries[i][1]]] - cnt[right[queries[i][0]]];
        }

        return res;
    }

}

class Test {
    public static void main(String[] args) {
        String str = "***|**|*****|**||**|*";
        Solution s = new Solution();
        int[][] q = {{5,11}};
        System.out.println(Arrays.toString(s.platesBetweenCandles(str, q)));
    }
}
