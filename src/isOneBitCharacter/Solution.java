package isOneBitCharacter;

/**
 * @author: ffzs
 * @Date: 2022/2/20 上午9:19
 */
public class Solution {

    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1) i += 2;
            else i++;
        }
        return i == bits.length - 1;
    }

}
