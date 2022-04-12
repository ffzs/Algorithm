package numberOfLines;

/**
 * @author: ffzs
 * @Date: 2022/4/12 上午8:13
 */
public class Solution {

    public int[] numberOfLines(int[] widths, String s) {
        int row = 1, width = 0;
        for (char c : s.toCharArray()) {
            int len = widths[c - 'a'];
            if (width + len > 100) {
                ++row;
                width = len;
            }
            else width += len;
        }
        return new int[] {row, width};
    }

}
