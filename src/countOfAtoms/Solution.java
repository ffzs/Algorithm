package countOfAtoms;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2021/7/5 上午6:57
 */
public class Solution {

    public String countOfAtoms(String formula) {
        Map<String, Integer> map = count(formula, 0 , formula.length()-1);
        List<String> arr = new ArrayList<>(map.keySet());
        arr.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            int v = map.get(s);
            sb.append(s);
            if (v > 1) sb.append(v);
        }
        return sb.toString();
    }

    private Map<String, Integer> count (String s, int l, int r) {
        Map<String, Integer> map = new HashMap<>();
        String v = "";

        for (int i = l; i <= r;) {
            if (Character.isDigit(s.charAt(i))) {
                int tmp = s.charAt(i) - '0';
                while (++i <= r && Character.isDigit(s.charAt(i))) {
                    tmp = tmp * 10 + s.charAt(i) - '0';
                }
                map.put(v, map.getOrDefault(v, 0) + tmp);
            }
            else if (s.charAt(i) == '(') {
                int count = 1;
                i ++;
                int sl = i;
                while (i <= r && count != 0) {
                    if (s.charAt(i) == '(') count++;
                    else if (s.charAt(i) == ')') count--;
                    i++;
                }
                Map<String, Integer> tmpMap = count(s, sl, i-2);
                int times;
                if (i > r) times = 1;
                else if (Character.isDigit(s.charAt(i))) {
                    times = s.charAt(i) - '0';
                    while (++i <= r && Character.isDigit(s.charAt(i))) times = times*10 + s.charAt(i) - '0';
                }
                else times = 1;
                for (Map.Entry<String, Integer> entry : tmpMap.entrySet()) {
                    map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue() * times);
                }
            }
            else {
                int sl = i;
                while (++i <= r && Character.isLowerCase(s.charAt(i)));
                v = s.substring(sl, i);
                if (i <= r && Character.isDigit(s.charAt(i))) {}
                else map.put(v, map.getOrDefault(v, 0) + 1);
            }
        }
        return map;
    }

}
