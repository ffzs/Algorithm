package RandomizedCollection;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: ffzs
 * @Date: 2020/10/31 上午8:52
 */
public class RandomizedCollection {
    private final Map<Integer, Set<Integer>> collect;
    private final List<Integer> vals;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        this.collect = new HashMap<>();
        this.vals = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        vals.add(val);
        if (!collect.containsKey(val)) collect.put(val, new HashSet<>());
        collect.get(val).add(vals.size()-1);
        return collect.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> set = collect.get(val);
        if (set == null || set.size() == 0) return false;
        else {
            int lastIndex = vals.size()-1;
            int lastValue = vals.get(lastIndex);
            if (lastValue == val) {
                set.remove(lastIndex);
            }
            else{
                int index = set.iterator().next();
                vals.set(index, lastValue);
                set.remove(index);
                Set<Integer> lastSet = collect.get(lastValue);
                lastSet.remove(lastIndex);
                lastSet.add(index);
            }
            vals.remove(lastIndex);
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return vals.get(ThreadLocalRandom.current().nextInt(vals.size()));
    }
}
