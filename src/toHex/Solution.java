package toHex;

/**
 * @author: ffzs
 * @Date: 2021/10/2 上午7:05
 */
public class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        final char[] cs = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(cs[num & 0xf]);
            num >>>= 4;
        } while (num > 0);
        return sb.reverse().toString();
    }
}
