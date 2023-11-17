package maximumSumQueries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/11/17 下午10:06
 */
public class Solution {

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length, m = queries.length;
        int[][] f = new int[n][2];
        int[][] g = new int[m][3];

        for (int i = 0; i < n; i++) {
            f[i] = new int[]{nums1[i], nums2[i]};
        }

        for (int i = 0; i < m; i++) {
            g[i] = new int[]{i, queries[i][0], queries[i][1]};
        }

        Arrays.sort(f, (a, b)-> b[0] - a[0]);
        Arrays.sort(g, (a, b)-> b[1] - a[1]);

        int[] res = new int[m];
        Arrays.fill(res, -1);
        List<int[]> stack = new ArrayList<>();
        int j = 0;
        for (int[] cur : g) {
            int i = cur[0], x = cur[1], y = cur[2];
            while (j < n && f[j][0] >= x) {
                int a = f[j][0], b = f[j][1];
                while (!stack.isEmpty() && stack.get(stack.size() - 1)[1] <= a + b) {
                    stack.remove(stack.size()-1);
                }

                if (stack.isEmpty() || stack.get(stack.size()-1)[0] < b) {
                    stack.add(new int[]{b, a + b});
                }
                j += 1;
            }

            int t = bSearch(stack, y);
            if (t < stack.size()) {
                res[i] = stack.get(t)[1];
            }
        }
        return res;
    }

    private int bSearch (List<int[]> stack, int target) {
        int l = 0, r = stack.size();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (stack.get(mid)[0] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }


}
