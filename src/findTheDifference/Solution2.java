package findTheDifference;

/**
 * @author: ffzs
 * @Date: 2020/12/18 上午8:07
 */
public class Solution2 {
    public char findTheDifference(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        char res = tc[tc.length-1];
        for (int i = 0; i < sc.length; i++) {
            res ^= sc[i];
            res ^= tc[i];
        }
        return res;
    }
}
