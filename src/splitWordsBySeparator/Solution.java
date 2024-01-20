package splitWordsBySeparator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2024/1/20 下午1:08
 */
public class Solution {
    List<String> res;
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        res = new ArrayList<>();
        for (String word : words) {
            split(word, separator);
        }
        return res;
    }

    private void split (String word, char separator) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (c == separator) {
                if (sb.length() == 0) continue;
                res.add(sb.toString());
                sb.delete(0, sb.length());
            }
            else sb.append(c);
        }
        if (sb.length() > 0) res.add(sb.toString());
    }

}
