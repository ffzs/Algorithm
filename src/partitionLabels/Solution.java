package partitionLabels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/10/22 上午8:15
 */

public class Solution {
    int[] tmp;
    List<Integer> res = new ArrayList<>();
    public List<Integer> partitionLabels(String S) {
        char[] seq = S.toCharArray();
        tmp = new int[26];
        Arrays.fill(tmp, -1);

        for (int i = 0; i < seq.length; i++) {
            tmp[seq[i]-'a'] = i;
        }

        int index = 0;
        while (index < seq.length) {
            int ret = partitionLabels(seq, index);
            res.add(ret+1);
            index += ret+1;
        }
        return res;
    }

    private int partitionLabels(char[] seq, int i) {

        int max = 0, j = i;
        do {
            max = Math.max(tmp[seq[j++] -'a'], max);
        } while (j < max);
        return max-i;
    }
}

class Test{
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels(S));
    }
}