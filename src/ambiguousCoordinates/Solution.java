package ambiguousCoordinates;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/11/7 下午3:33
 */
public class Solution {

    public List<String> ambiguousCoordinates(String s) {
        s = s.substring(1, s.length()-1);
        List<String> res = new ArrayList<>();
        int n = s.length();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder(s);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            s1.append(s.charAt(i));
            s2.deleteCharAt(0);
            List<String> r1 = helper(s1.toString());
            if (r1.size() == 0) continue;
            List<String> r2 = helper(s2.toString());
            if (r2.size() == 0) continue;
            for (String sub1 : r1) {
                for (String sub2 : r2) {
                    sb.append('(').append(sub1).append(", ").append(sub2).append(')');
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        return res;
    }

    private List<String> helper (String str) {
        List<String> ret = new ArrayList<>();
        int n = str.length();
        if (n == 1) {
            ret.add(str);
        }
        else{
            if (str.charAt(0) == '0') {
                if (str.charAt(n-1) != '0') {
                    StringBuilder sb = new StringBuilder(str);
                    sb.insert(1, '.');
                    ret.add(sb.toString());
                }
            }
            else {
                if (str.charAt(n-1) == '0') ret.add(str);
                else {
                    StringBuilder sb = new StringBuilder(str);
                    ret.add(sb.toString());
                    for (int i = 1; i < n; i++) {
                        sb.insert(i, '.');
                        ret.add(sb.toString());
                        sb.deleteCharAt(i);
                    }
                }
            }
        }
        return ret;
    }

}
