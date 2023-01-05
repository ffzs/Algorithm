package countPairs2;

/**
 * @author: ffzs
 * @Date: 2023/1/5 下午2:13
 */
public class Solution {
    class Trie {
        Trie[] ch = new Trie[2];
        int cnt = 0;
    }

    Trie root = new Trie();
    private void insert (int num) {
        Trie node = root;
        int bit;
        for (int i = 14; i >= 0; i--) {
            bit = (num >> i) & 1;
            if (node.ch[bit] == null) node.ch[bit] = new Trie();
            node = node.ch[bit];
            node.cnt += 1;
        }
    }

    private int query (int num, int limit) {
        Trie node = root;
        int ret = 0;
        int bit;
        for (int i = 14; i >= 0; i--) {
            if (node == null) return ret;
            bit = (num >> i) & 1;
            if (((limit >> i) & 1 )== 1) {
                // A ^ B == 0 （bit_a == bit_b）的 可以肯定是比 1 小的 即 比 limit 小
                if (node.ch[bit] != null) ret += node.ch[bit].cnt;
                node = node.ch[1 ^ bit];
            }
            else node = node.ch[bit];
        }
        return ret;
    }
    public int countPairs(int[] nums, int low, int high) {
        int res = 0;
        for (int num : nums) {
            res += query(num, high + 1) - query(num, low);
            insert(num);
        }
        return res;
    }

}
