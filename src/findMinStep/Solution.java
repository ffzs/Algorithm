package findMinStep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/11/9 上午7:24
 */

public class Solution {
    static private int[] map = new int[26];
    static char[] colors = {'R', 'Y', 'B', 'G', 'W'};
    static {
        for (int i = 0; i < colors.length; i++) {
            map[colors[i] - 'A'] = i;
        }
    }
    private int[] h = new int[5];
    private int res = Integer.MAX_VALUE;
    public int findMinStep(String board, String hand) {
        for (char c : hand.toCharArray()) {
            h[map[c - 'A']]++;
        }
        dfs(new StringBuilder(board), 0);
        return res == Integer.MAX_VALUE? -1: res;
    }

    private void dfs(StringBuilder str, int step) {
        removeDup(str);
        if (step > res) return;
        if (str.length() == 0) {
            res = Math.min(res, step);
            return;
        }

        int i = 0, j;
        while (i < str.length()) {
            j = i + 1;
            while (j < str.length() && str.charAt(j) == str.charAt(i)) j ++;
            if (j - i == 1) {
                StringBuilder tmp = new StringBuilder(str);
                int idx = map[tmp.charAt(i) - 'A'];
                if (h[idx] >=2) {
                    h[idx] -= 2;
                    dfs(tmp.deleteCharAt(i), step + 2);
                    h[idx] += 2;
                }
            }
            else {
                for (int k = 0; k < h.length; k++) {
                    if (h[k] == 0) continue;
                    StringBuilder tmp = new StringBuilder(str);
                    h[k] --;
                    dfs(tmp.insert(i + 1, colors[k]), step + 1);
                    h[k] ++;
                }
            }
            i = j;
        }
    }
    
    private void removeDup(StringBuilder sb) {
        int i = 0, j = 1;
        while(i < sb.length()){
            while(j < sb.length() && sb.charAt(j) == sb.charAt(i)) j++;
            if(j - i > 2){
                sb.delete(i, j);
                j = i + 1;
                while(i>0 && i<sb.length() && sb.charAt(i-1) == sb.charAt(i)) i--;
            }else{
                i = j;
                j++;
            }
        }
    }
}
