package MyHashSet;

import java.util.HashMap;

/**
 * @author: ffzs
 * @Date: 2021/3/13 下午1:05
 */
public class MyHashSet {
    private HashMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new HashMap<>();
    }

    public void add(int key) {
        map.put(key, 1);
    }

    public void remove(int key) {
        map.remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map.containsKey(key);
    }
}
