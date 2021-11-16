package maxProduct;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/11/17 上午7:30
 */
public class Solution {

    public int maxProduct(String[] words) {
        int[] masks = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            masks[i] = s2bin(words[i]);
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }

    private int s2bin(String str) {
        int ret = 0;
        for (char c : str.toCharArray()) {
            ret |= (1<<(c-'a'));
        }
        return ret;
    }

}
