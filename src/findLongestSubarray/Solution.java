package findLongestSubarray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] findLongestSubarray(String[] array) {

        int diff, letters = 0, digits = 0, maxLen = 0, l = 0, r = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            char c = array[i].charAt(0);
            if (c >= '0' && c <= '9') digits += 1;
            else letters += 1;
            diff = letters - digits;
            if (map.containsKey(diff)) {
                if (i - map.get(diff) > maxLen) {
                    r = i;
                    l = map.get(diff) + 1;
                    maxLen = i - map.get(diff);
                }
            }
            else {
                map.put(diff, i);
            }
        }
        if (r == 0) return new String[0];
        String[] res = new String[r - l + 1];
        if (r + 1 - l >= 0) System.arraycopy(array, l, res, 0, r + 1 - l);
        return res;
    }
}