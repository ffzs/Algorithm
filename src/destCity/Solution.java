package destCity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: ffzs
 * @Date: 2021/10/1 上午6:48
 */
public class Solution {

    public String destCity(List<List<String>> paths) {
        Set<String> s1 = new HashSet<>();
        for (List<String> path : paths) {
            s1.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!s1.contains(path.get(1))) return path.get(1);
        }
        return "";
    }

}
