package maxDepth3;

/**
 * @author: ffzs
 * @Date: 2022/1/7 上午7:57
 */
public class Solution {

    public int maxDepth(String s) {
        int depth = 0, maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') depth++;
            else if (c == ')') {
                maxDepth = Math.max(depth, maxDepth);
                depth--;
            }
        }
        return maxDepth;
    }

}
