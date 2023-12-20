package isAcronym;

import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/12/20 上午8:07
 */
public class Solution {

    public boolean isAcronym(List<String> words, String s) {

        if (words.size() != s.length()) return false;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) return false;
        }
        return true;
    }

}
