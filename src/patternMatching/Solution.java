package patternMatching;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/22
 */
public class Solution {
    public static boolean patternMatching(String pattern, String value) {

        // 单个 a或者b 一定为true
        if (pattern.length() == 1) return true;
        // p,v都为空则为 true
        else if (pattern.length() == 0) return value.length() == 0;
        else if (value.length() == 0) return false;

        char[] pChar = pattern.toCharArray();
        char[] vChar = value.toCharArray();
        
        int countA = 0;
        for (char c : pChar) {
            if (c == 'a') countA++;
        }
        int countB = pChar.length - countA;

        // 判断 只有a或者b的情况
        if (countA == 0 || countB == 0) {
            if (vChar.length % pChar.length != 0) {
                return false;
            }
            else {
                int len = vChar.length / pChar.length;
                for (int i = 1; i < pChar.length; ++i) {
                    if (!isMatch(vChar, 0, i*len, len)) return false;
                }
                return true;
            }
        }
        else if (countA == 1 && countB == 1) return true;

        for (int lenA = 0; countA * lenA <= vChar.length ; lenA++) {
            if ((vChar.length - countA * lenA) % countB == 0) {
                int lenB = (vChar.length - countA * lenA) / countB;
                int ai = -1, bi = -1 , index = 0;
                for (int i = 0; i < pChar.length; i++) {
                    if (pChar[i] == 'a') {
                        if (ai == -1) ai = index;
                        else {
                            if (!isMatch(vChar, ai, index, lenA)) break ;
                        }
                        index += lenA;
                    }
                    else {
                        if (bi == -1) bi = index;
                        else {
                            if (!isMatch(vChar, bi, index, lenB)) break ;
                        }
                        index += lenB;
                    }
                    if (lenA == lenB && bi == -1 && ai == -1) {
                        if (isMatch(vChar, ai, bi, lenA)) break;
                    }
                }
                if (index == vChar.length ) return true;
            }
        }
        return false;
    }

    private static boolean isMatch (char[] s, int s1, int s2, int len) {

        for (int i = 0; i < len; ++i) {
            if (s[s1+i] != s[s2+i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String p = "bb";
        String v = "";
        System.out.println(patternMatching(p,v));
    }
}
