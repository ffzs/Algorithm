package isFlipedString;

/**
 * @author: ffzs
 * @Date: 2022/9/29 上午9:02
 */
public class Solution {

    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }

}
