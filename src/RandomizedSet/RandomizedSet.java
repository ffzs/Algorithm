package RandomizedSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: ffzs
 * @Date: 2022/4/13 上午8:34
 */
public class RandomizedSet {

    List<Integer> lst = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        lst.add(val);
        map.put(val, lst.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int lastIndex = lst.size() - 1, idx = map.get(val);
        int lastValue = lst.get(lastIndex);
        lst.set(idx, lastValue);
        map.put(lastValue, idx);
        lst.remove(lastIndex);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return lst.get(ThreadLocalRandom.current().nextInt(lst.size()));
    }

}
