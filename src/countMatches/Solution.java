package countMatches;

import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/10/29 下午7:34
 */
public class Solution {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0, idx = getIndex(ruleKey);
        for (List<String> item : items) {
            if (item.get(idx).equals(ruleValue)) res += 1;
        }
        return res;
    }

    private int getIndex (String key) {
        switch (key) {
            case "type":
                return 0;
            case "color":
                return 1;
            case "name":
                return 2;
            default:
                return -1;
        }
    }

}
