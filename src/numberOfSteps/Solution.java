package numberOfSteps;

/**
 * @author: ffzs
 * @Date: 2022/1/31 上午6:34
 */
public class Solution {

    public int numberOfSteps(int num) {
        if (num == 0) return 0;
        int res = 0;
        while (num != 0) {
            res += (num & 1) + 1;
            num >>= 1;
        }
        return res - 1;
    }

}
