package judgeCircle;

/**
 * @author: ffzs
 * @Date: 2020/8/28 上午7:25
 */

public class Solution {

    public boolean judgeCircle(String moves) {
        char[] seq = moves.toCharArray();
        if ((seq.length & 1) == 1) return false;
        int[] count = new int[26];
        for (char c : seq) {
            count[c-'A']++;
        }
        return count['R'-'A'] == count['L'-'A'] && count['U'-'A'] == count['D'-'A'];
    }
}
