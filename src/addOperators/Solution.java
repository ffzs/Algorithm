package addOperators;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/10/16 上午7:27
 */

public class Solution {
    List<String> res = new ArrayList<>();
    char[] cs;
    int target;
    int n;
    public List<String> addOperators(String num, int target) {
        this.cs = num.toCharArray();
        this.target = target;
        this.n = num.length();
        backtrack(new StringBuilder(), 0, 0, 0);
        return res;
    }

    private void backtrack(StringBuilder sb, int i, long ret, long mul) {
        if (i == n) {
            if (ret == target) res.add(sb.toString());
            return;
        }

        int index = sb.length();
        if (i > 0) sb.append(0);

        long val = 0;
        for (int j = i; j < n && (j == i || cs[i] != '0'); j++) {
            val = val * 10 + cs[j] - '0';
            sb.append(cs[j]);
            if (i == 0) backtrack(sb, j + 1, val, val);
            else {
                sb.setCharAt(index, '+');
                backtrack(sb, j + 1, ret + val, val);
                sb.setCharAt(index, '-');
                backtrack(sb, j + 1, ret - val, -val);
                sb.setCharAt(index, '*');
                backtrack(sb, j + 1, ret - mul + val * mul, val * mul);
            }
        }
        sb.setLength(index);
    }

}
