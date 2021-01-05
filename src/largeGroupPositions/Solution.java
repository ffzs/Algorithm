package largeGroupPositions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2021/1/5 上午8:22
 */
public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        char[] cs = s.toCharArray();

        int left = 0, right = 0;
        while (left < cs.length-2) {
            while (right<cs.length && cs[right] == cs[left]) right++;
            if ((right-left)>2) res.add(Arrays.asList(left, right-1));
            left = right;
        }
        return res;
    }
}
