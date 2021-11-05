package longestSubsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/11/5 上午7:19
 */
public class Solution {

    public int longestSubsequence(int[] arr, int difference) {
        int res = 1;
        int[] map = new int[40001];
        for (int i : arr) {
            map[i + 20000] = map[i - difference + 20000] + 1;
            res = Math.max(res, map[i + 20000]);
        }
        return res;
    }
}

class Test{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8};
        System.out.println(s.longestSubsequence(arr, 0));
    }
}
