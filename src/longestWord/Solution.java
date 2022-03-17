package longestWord;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2022/3/17 上午7:53
 */
public class Solution {

    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        String res = "";
        for (int i = words.length - 1; i >= 0; i--) {
            String word = words[i];
            if (word.length() > res.length() || word.length() == res.length() && word.compareTo(res) < 0) {
                if (isValid(set, word)) res = word;
            }
        }
        return res;
    }

    private boolean isValid(Set<String> set, String word) {
        int n = word.length();
        StringBuilder sb = new StringBuilder(word);
        for (int i = n-1; i > 0; i--) {
            sb.deleteCharAt(i);
            if (!set.contains(sb.toString())) return false;
        }
        return true;
    }

}

class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
        System.out.println(s.longestWord(words));
    }
}
