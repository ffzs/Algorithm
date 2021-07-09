package TimeMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/7/10 上午6:57
 */
public class TimeMap {
    Map<String, Map<String, Integer> > map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new HashMap<>(){{put(value, timestamp);}});
        }
        else {
            Map<String, Integer> subMap = map.get(key);
            if (!subMap.containsKey(value)) subMap.put(value, timestamp);
            else {
                int the_time = subMap.get(value);
                if (timestamp > the_time) subMap.put(value, timestamp);
            }
        }
    }

    public String get(String key, int timestamp) {
        int max = Integer.MIN_VALUE;
        String v = "";
        Map<String, Integer> subMap = map.getOrDefault(key, new HashMap<>());
        for (Map.Entry<String, Integer> entry : subMap.entrySet()) {
            int the_time = entry.getValue();
            if (timestamp>=the_time && the_time>max) {
                v = entry.getKey();
                max = the_time;
            }
        }
        return v;
    }

}
