package maxLength;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/6/19 上午9:20
 */
public class Solution {

    int res = 0;
    List<Integer> masks;
    int n;

    public int maxLength(List<String> arr) {
        masks = new ArrayList<>();

        for (String s : arr) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                int cc = c - 'a';
                if (((mask >> cc) & 1) != 0) {
                    mask = 0;
                    break;
                }
                mask |= 1 << cc;
            }
            if (mask > 0) masks.add(mask);
        }
        n = masks.size();
        dfs(0, 0);
        return res;
    }

    private void dfs(int index, int mask) {
        if (index == n) {
            res = Math.max(res, Integer.bitCount(mask));
            return;
        }

        if ((mask & masks.get(index)) == 0) dfs(index + 1, mask | masks.get(index));
        dfs(index + 1, mask);
    }
}
