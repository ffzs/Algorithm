package maximizeXor;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: ffzs
 * @Date: 2021/5/23 上午7:35
 */
public class Solution2 {

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];

        Arrays.sort(nums);
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) nums[n++] = nums[i];
        }

        int[][] queries_ = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            res[i] = -1;
            queries_[i][0] = queries[i][0];
            queries_[i][1] = queries[i][1];
            queries_[i][2] = i;
        }

        Arrays.sort(queries_, Comparator.comparingInt(a -> a[1]));
        Trie tree = new Trie();
        int i = 0;
        for (int[] query : queries_) {
            int x = query[0], m = query[1], idx = query[2];
            while (i < n && nums[i] <= m) tree.insert(nums[i++]);

            if (i != 0) res[idx] = tree.findMax(x);
        }

        return res;
    }

    static class Trie {
        private static final int L = 30;
        Trie[] children = new Trie[2];


        private void insert (int v) {
            Trie tree = this;
            for (int l = L-1; l >= 0; l--) {
                int b = (v >> l) & 1;
                if (tree.children[b] == null) tree.children[b] = new Trie();
                tree = tree.children[b];
            }
        }

        private int findMax(int v) {
            int ret = 0;

            Trie tree = this;
            for (int l = L-1; l >= 0; l--) {
                int b = (v>>l) & 1;
                if (tree.children[b ^ 1] != null) {
                    ret |= 1<<l;
                    b ^= 1;
                }
                tree = tree.children[b];
            }
            return ret;
        }
    }

}
