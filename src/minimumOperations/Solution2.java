package minimumOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/10/1 上午9:02
 */
public class Solution2 {

    public int minimumOperations(String leaves) {
        char[] seq = leaves.toCharArray();
        int res = 0, i = 0, j = seq.length-1;
        if (seq[0] != 'r') {
            seq[0] = 'r';
            res++;
        }
        if (seq[seq.length-1] != 'r') {
            seq[seq.length-1] = 'r';
            res++;
        }
        // 将两边的red去掉
        while (i<seq.length && seq[i] == 'r') i++;
        while (j >=0 && seq[j] == 'r') j--;

        if (i > j) return res + 1;
        int max = 0, pre = 0, min_pre = seq.length;
        int yellow = 0;
        while (i <= j) {
            int tmp = 0;
            if (seq[i] == 'y') {
                while (seq[i] == 'y') {
                    i++; tmp++;
                }
                yellow += tmp;
                pre += tmp;
                max = Math.max(max, pre);
                if (min_pre != seq.length) max = Math.max(max, pre-min_pre);
            }
            else {
                while (seq[i] == 'r') {
                    i++; tmp++;
                }
                pre -= tmp;
                min_pre = Math.min(pre, min_pre);
            }
        }
        return res + yellow -max;
    }
}
