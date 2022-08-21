package isPrefixOfWord;

/**
 * @author: ffzs
 * @Date: 2022/8/21 下午12:25
 */
public class Solution {

    public int isPrefixOfWord(String sentence, String searchWord) {
        char[] cs = sentence.toCharArray(), word = searchWord.toCharArray();
        int idx = 1;
        for (int i = 0; i < cs.length; i++) {
            if (i == 0 || cs[i] == ' ') {
                for (int j = 0, k = i == 0 ? 0 : i + 1; j < word.length; j++, k++) {
                    if (word[j] != cs[k]) break;
                    else if (j == word.length - 1) return idx;
                }
                idx += 1;
            }
        }
        return -1;
    }
}
