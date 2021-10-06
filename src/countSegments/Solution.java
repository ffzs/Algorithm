package countSegments;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/10/7 上午6:16
 */

public class Solution {

    public int countSegments(String s) {
        return (int) Arrays.stream(s.split(" ")).filter(it -> !it.equals("")).count();
    }

}
