package letterCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2020/8/26 上午7:20
 */

public class Solution {
    private final Map<Character, String> letterMap = new HashMap<>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
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
            char[] letters = letterMap.get(seq[index]).toCharArray();
            for (char letter : letters) {
                s.append(letter);
                dfs(index+1, s);
                s.deleteCharAt(index);
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits = "23";
        System.out.println(solution.letterCombinations(digits));
    }
}
