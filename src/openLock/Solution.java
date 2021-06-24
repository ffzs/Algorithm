package openLock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/6/25 上午6:56
 */
public class Solution {

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> set1 = new HashSet<>(), set2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int res = 0;
        set1.add("0000");
        set2.add(target);
        while (!set1.isEmpty() && !set2.isEmpty()) {
            Set<String> tmp = new HashSet<>();
            for (String cur : set1) {

                if (deads.contains(cur)) continue;
                if (set2.contains(cur)) return res;
                visited.add(cur);

                for (int i = 0; i < 4; i++) {
                    String add_one = get_next(cur, i, true);
                    if (!visited.contains(add_one)) tmp.add(add_one);
                    String minus_one = get_next(cur, i, false);
                    if (!visited.contains(minus_one)) tmp.add(minus_one);
                }
            }
            res ++;
            set1 = set2;
            set2 = tmp;
        }

        return -1;

    }

    private String get_next(String it, int i, boolean add_one){
        char[] cur = it.toCharArray();
        if (add_one) {
            if (cur[i] == '9') cur[i] = '0';
            else cur[i] += 1;
        }
        else{
            if (cur[i] == '0') cur[i] = '9';
            else cur[i] -= 1;
        }
        return new String(cur);
    }

}
