package removeSubfolders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2023/2/8 上午8:28
 */
public class Solution {

    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Arrays.sort(folder);

        String pre = folder[0];
        res.add(pre);
        for (int i = 1; i < folder.length; i++) {
            if (compare(pre, folder[i])) continue;
            pre = folder[i];
            res.add(pre);
        }
        return res;
    }

    private boolean compare (String a, String b) {
        if (a.length() > b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return b.charAt(a.length()) == '/';
    }

}
