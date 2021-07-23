package maximumTime;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/7/24 上午7:02
 */
public class Solution {

    public String maximumTime(String time) {
        char[] cs = time.toCharArray();

        if (cs[0] == '?') {
            if (cs[1] == '?') {
                cs[0] = '2';
                cs[1] = '3';
            }
            else if (cs[1] - '0' <=3 ){
                cs[0] = '2';
            }
            else cs[0] = '1';
        }
        if (cs[1] == '?') {
            if (cs[0] == '2') cs[1] = '3';
            else cs[1] = '9';
        }
        if (cs[3] == '?') {
            cs[3] = '5';
        }
        if (cs[4] == '?') cs[4] = '9';

        return new String(cs);
    }

}
