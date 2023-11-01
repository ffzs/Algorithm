package countPoints2;

/**
 * @author: ffzs
 * @Date: 2023/11/2 上午3:52
 */
public class Solution {

    public int countPoints(String rings) {
        int[] rods = new int[10];
        char[] cs = rings.toCharArray();

        for (int i = 0; i < cs.length; i+=2) {
            char color = cs[i];
            int num = cs[i+1] - '0';

            if (color == 'R') rods[num] |= 0b001;
            else if (color == 'G') rods[num] |= 0b010;
            else rods[num] |= 0b100;
        }

        int res = 0;
        for (int i = 0; i < 10; i++) {
            if (rods[i] == 0b111) res += 1;
        }
        return res;
    }

}
