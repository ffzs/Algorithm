package evaluate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2022/7/6 下午2:52
 */
public class Solution {

    Map<String, List<Integer>> map;
    char[] expr;
    int start;
    public int evaluate(String expression) {
        map = new HashMap<>();
        start = 0;
        expr = expression.toCharArray();
        return helper();
    }

    private int helper() {
        if (expr[start] != '(') {
            if ((expr[start] >= '0' && expr[start] <= '9') || expr[start] == '-') {
                return getInt();
            }
            else {
                String var = getVar();
                List<Integer> lst = map.get(var);
                return lst.get(lst.size()-1);
            }
        }
        int ret = 0;
        start += 1;
        if (expr[start] == 'a') {
            start += 4;
            int a = helper();
            start += 1;
            int b = helper();
            ret = a + b;
        }
        else if (expr[start] == 'm') {
            start += 5;
            int a = helper();
            start += 1;
            int b = helper();
            ret = a * b;
        }
        else {
            start += 4;
            List<String> vars = new ArrayList<>();
            while (true) {
                if (expr[start] > 'z' || expr[start] < 'a') {
                    ret = helper();
                    break;
                }
                String v = getVar();
                if (expr[start] == ')') {
                    List<Integer> lst = map.get(v);
                    ret = lst.get(lst.size() - 1);
                    break;
                }
                vars.add(v);
                start += 1;
                int a = helper();
                if (!map.containsKey(v)) map.put(v, new ArrayList<>());
                map.get(v).add(a);
                start += 1;
            }

            for (String var : vars) {
                List<Integer> lst = map.get(var);
                if (lst.size() == 1) map.remove(var);
                else lst.remove(lst.size()-1);
            }
        }
        start += 1;
        return ret;
    }

    private int getInt() {
        int ret = 0, sign = expr[start] == '-'? -1 : 1;
        if (expr[start] == '-') start += 1;
        while (start < expr.length && expr[start] != ' ' && expr[start] != ')') {
            ret = ret * 10 + expr[start++] - '0';
        }
        return sign * ret;
    }

    private String getVar() {
        StringBuilder sb = new StringBuilder();
        while (start < expr.length && expr[start] != ' ' && expr[start] != ')') {
            sb.append(expr[start++]);
        }
        return sb.toString();
    }

}
