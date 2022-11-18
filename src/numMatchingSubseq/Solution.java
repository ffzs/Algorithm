package numMatchingSubseq;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/11/17 下午7:44
 */
public class Solution {

    public int numMatchingSubseq(String s, String[] words) {
        Queue<int[]>[] q = new Queue[26];
        for (int i = 0; i < 26; i++) {
            q[i] = new LinkedList<>();
        }
        for (int i = 0; i < words.length; i++) {
            q[words[i].charAt(0) - 'a'].offer(new int[]{i, 0});
        }

        int res = 0;
        for (char c : s.toCharArray()) {
            Queue<int[]> it = q[c - 'a'];
            int size = it.size();
            for (int i = 0; i < size; i++) {
                int[] cur = it.poll();
                if (cur[1] == words[cur[0]].length() - 1) res += 1;
                else {
                    cur[1] += 1;
                    q[words[cur[0]].charAt(cur[1]) - 'a'].offer(cur);
                }
            }
        }
        return res;
    }

}
