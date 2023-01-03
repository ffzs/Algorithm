package areNumbersAscending;

/**
 * @author: ffzs
 * @Date: 2023/1/3 上午10:21
 */
public class Solution {

    public boolean areNumbersAscending(String s) {
        char[] cs = s.toCharArray();
        int pre = -1;
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            if (cs[i]>='0' && cs[i] <= '9') {
                int num = 0;
                while (i < n && cs[i] >= '0' && cs[i] <='9'){
                    num *= 10;
                    num += cs[i++] - '0';
                }
                if (num <= pre) return false;
                pre = num;
                i--;
            }
        }
        return true;
    }

}
