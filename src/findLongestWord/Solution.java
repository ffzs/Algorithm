package findLongestWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/9/14 上午6:48
 */
public class Solution {

    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a,b)-> {
            if (a.length() != b.length()) return b.length() - a.length();
            else return a.compareTo(b);
        });

        for (String d : dictionary) {
            int i = 0, j = 0;
            while (i < d.length() && j < s.length()) {
                if (d.charAt(i) == s.charAt(j)) i++;
                j++;
            }
            if (i == d.length()) return d;
        }
        return "";
    }

}
