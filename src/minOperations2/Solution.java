package minOperations2;

/**
 * @author: ffzs
 * @Date: 2022/9/9 上午8:37
 */
public class Solution {

    public int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if (log.equals("./"))
                continue;
            else if (log.equals("../")) {
                if (res == 0) continue;
                res -= 1;
            }
            else res += 1;
        }
        return res;
    }
}
