package makeLargestSpecial;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/8/8 上午9:54
 */
public class Solution {

    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) return s;

        int cnt = 0, l = 0;

        List<String> lst = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') cnt += 1;
            else {
                cnt -= 1;
                if (cnt == 0) {
                    lst.add("1" + makeLargestSpecial(s.substring(l + 1, i)) + "0");
                    l = i + 1;
                }
            }
        }

        lst.sort(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String s1 : lst) {
            sb.append(s1);
        }
        return sb.toString();
    }

}
