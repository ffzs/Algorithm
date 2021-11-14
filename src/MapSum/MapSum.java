package MapSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/11/14 上午7:27
 */
public class MapSum {
    Map<String, Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int ret = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key.length() >= prefix.length() && key.substring(0, prefix.length()).equals(prefix)) ret+=entry.getValue();
        }
        return ret;
    }

}
