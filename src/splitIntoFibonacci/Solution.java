package splitIntoFibonacci;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/12/8 下午7:46
 */
public class Solution {

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        dfs(S.toCharArray(), res, 0);
        return res;
    }

    private boolean dfs(char[] cs, List<Integer> list, int index) {
        if (index == cs.length) return list.size() >= 3;

        long curL = 0L;
        for (int i = index; i < cs.length; i++) {
            if (i > index && cs[index] == '0') break;
            curL = curL * 10 + cs[i] - '0';
            if (curL > Integer.MAX_VALUE) break;
            int cur = (int)curL, size = list.size();
            if (size >= 2) {
                int sum = list.get(size-1) + list.get(size-2);
                if (cur < sum) continue;
                else if (cur > sum) break;
            }
            list.add(cur);
            if (dfs(cs, list, i+1)) return true;
            else list.remove(list.size()-1);
        }
        return false;
    }
}
