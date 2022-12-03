package secondHighest;

/**
 * @author: ffzs
 * @Date: 2022/12/3 下午2:46
 */
public class Solution {

    public int secondHighest(String s) {
        char[] cs = s.toCharArray();
        int first = -1, second = -1;
        for (char c : cs) {
            if (c >= '0' && c <= '9') {
                int num = c - '0';
                if (num > first) {
                    second = first;
                    first = num;
                } else if (num != first && num > second) second = num;
            }
        }
        return second;
    }

}
