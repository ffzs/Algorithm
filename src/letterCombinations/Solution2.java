package letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2020/8/26 上午7:58
 */
public class Solution2 {
    private final String[] letterMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private char[] seq;
    private List<String> res = new ArrayList<>();;
    public List<String> letterCombinations(String digits) {
        this.seq = digits.toCharArray();
        if (seq.length==0) return new ArrayList<>();
        dfs(0, new StringBuilder());
        return res;
    }

    private void dfs (int index, StringBuilder s) {
        if (index == seq.length) {
            res.add(String.valueOf(s));
        }
        else {
            char[] letters = letterMap[seq[index]-'0'].toCharArray();
            for (char letter : letters) {
                s.append(letter);
                dfs(index+1, s);
                s.deleteCharAt(index);
            }
        }
    }
}
