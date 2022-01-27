package countValidWords;

/**
 * @author: ffzs
 * @Date: 2022/1/27 上午7:50
 */
public class Solution {

    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        int res = 0;
        for (String word : words) {
            if (word.length() > 0 && isWord(word)) res++;
        }
        return res;
    }

    private boolean isWord(String word) {
        char[] cs = word.toCharArray();
        int cnt = 0;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (isSuper(c) || isUnder(c)) continue;
            else if ( c >= '0' && c <= '9') return false;
            else if (c == '-') {
                if (cnt == 1 || i == 0 || i == cs.length - 1 || !isUnder(cs[i-1]) || !isUnder(cs[i+1])) return false;
                cnt++;
            }
            else {
                if (i != cs.length - 1) return false;
            }
        }
        return true;
    }

    private boolean isUnder(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isSuper (char c) {
        return c >= 'A' && c <= 'Z';
    }

}
