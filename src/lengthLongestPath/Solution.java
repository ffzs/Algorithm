package lengthLongestPath;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/4/20 上午8:29
 */
public class Solution {

    public int lengthLongestPath(String input) {
        int[] tmp = new int[20];
        int res = 0, cur;
        boolean isFile = false;
        char[] cs = input.toCharArray();

        int i = 0;
        while (i < cs.length) {
            int depth = 0;
            while (cs[i] == '\t') {
                ++ depth;
                ++ i;
            }

            cur = 0;
            while (i < cs.length && cs[i++] != '\n') {
                if (i < cs.length && cs[i] == '.') isFile = true;
                ++cur;
            }

            tmp[depth] = cur;
            if (isFile) {
                cur = 0;
                for (int j = 0; j <= depth; j++) {
                    cur += tmp[j];
                }
                res = Math.max(res, cur + depth);
                isFile = false;
            }
        }
        return res;
    }

}
