package parseBoolExpr;

/**
 * @author: ffzs
 * @Date: 2022/11/5 下午2:56
 */
public class Solution {

    public boolean parseBoolExpr(String expression) {
        char[] cs = expression.toCharArray();
        return parseBool(cs, 0, cs.length-1);
    }

    private boolean parseBool (char[] cs, int l, int r) {
        char c = cs[l];
        if (c == 't') return true;
        else if (c == 'f') return false;
        else if (c == '!') {
            return !parseBool(cs, l + 2, r - 1);
        }
        else if (c == '&') {
            boolean ret = true;
            int cnt = 0, start = l + 2;
            for (int i = l + 2; i <= r; i++) {
                if (cs[i] == '(') cnt += 1;
                else if (cs[i] == ')') cnt -= 1;
                if ((cnt == 0 && cs[i] == ',') || i == r) {
                    ret &= parseBool(cs, start, i - 1);
                    start = i + 1;
                }
            }
            return ret;
        }
        else {
            boolean ret = false;
            int cnt = 0, start = l + 2;
            for (int i = l + 2; i <= r; i++) {
                if (cs[i] == '(') cnt += 1;
                else if (cs[i] == ')') cnt -= 1;
                if ((cnt == 0 && cs[i] == ',') || i == r) {
                    ret |= parseBool(cs, start, i - 1);
                    start = i + 1;
                }
            }
            return ret;
        }
    }

}
