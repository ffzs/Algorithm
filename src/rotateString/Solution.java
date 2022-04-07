package rotateString;

/**
 * @author: ffzs
 * @Date: 2022/4/7 上午8:28
 */
public class Solution {

    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && goal.concat(goal).contains(s);
    }

}
