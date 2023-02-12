package alphabetBoardPath;

/**
 * @author: ffzs
 * @Date: 2023/2/12 上午8:58
 */
public class Solution {

    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;
        char[] cs = target.toCharArray();
        for (char c : cs) {
            int cx = (c - 'a') % 5, cy = (c - 'a') / 5, dx = cx - x, dy = cy - y;
            if (dx < 0) sb.append("L".repeat(-dx));
            if (dy < 0) sb.append("U".repeat(-dy));
            if (dx > 0) sb.append("R".repeat(dx));
            if (dy > 0) sb.append("D".repeat(dy));
            sb.append('!');
            x = cx;
            y = cy;
        }
        return sb.toString();
    }

}
