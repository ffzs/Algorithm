package toGoatLatin;

/**
 * @author: ffzs
 * @Date: 2022/4/21 上午8:17
 */
public class Solution {
    static boolean[] isVowel = new boolean[(int)'z' + 1];
    static {
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        int gap = 'a' - 'A';
        for (char c : vowel) {
            isVowel[c] = true;
            isVowel[c - gap] = true;
        }
    }
    public String toGoatLatin(String sentence) {
        char[] cs = sentence.toCharArray();
        StringBuilder res = new StringBuilder();
        int n = cs.length;
        int i = 0, cnt = 1;
        char consonant = '#';
        while (i < n) {
            if (!isVowel[cs[i]]) {
                consonant = cs[i++];
            }
            while (i < n && cs[i] != ' ') {
                res.append(cs[i++]);
            }
            if (consonant != '#') {
                res.append(consonant);
                consonant = '#';
            }
            res.append("ma").append("a".repeat(cnt++));
            i++;
            if (i < n) res.append(' ');
        }
        return res.toString();
    }

}
