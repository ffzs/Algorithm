package repeatedSubstringPattern;

/**
 * @author: ffzs
 * @Date: 2020/8/24 上午8:35
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        char[] seq = s.toCharArray();
        for (int i = 0; i < len/2; i++) {
            if (isRepeat(seq, i)) return true;
        }
        return false;
    }

    private boolean isRepeat (char[] seq, int end) {
        if (seq.length % ( end+1 ) != 0) return false;
        int times = seq.length / ( end+1 );
        if (times == 1) return false;
        for (int i = 0; i <= end; i++) {
            for (int j = 1; j < times; j++) {
                if (seq[i] != seq[j*(end+1)+i]) return false;
            }
        }
        return true;
    }
}
