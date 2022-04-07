package rotateString;

/**
 * @author: ffzs
 * @Date: 2022/4/7 上午8:28
 */
public class Solution {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String g = goal + goal;
        return g.contains(s);
    }

}
