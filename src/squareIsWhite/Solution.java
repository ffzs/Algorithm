package squareIsWhite;

/**
 * @author: ffzs
 * @Date: 2022/12/8 下午2:34
 */
public class Solution {

    public boolean squareIsWhite(String coordinates) {
        int a = coordinates.charAt(0) - 'a', b = coordinates.charAt(1) - '1';
        return ((a + b) & 1) == 0;
    }

}
