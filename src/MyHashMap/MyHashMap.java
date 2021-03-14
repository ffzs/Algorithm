package MyHashMap;

import java.util.LinkedList;

/**
 * @author: ffzs
 * @Date: 2021/3/14 下午5:36
 */
public class MyHashMap {
    private final int BASE = 731;
    private LinkedList[] box;

    /** Initialize your data structure here. */
    public MyHashMap() {
        box = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            box[i] = new LinkedList<int[]>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = getHash(key);
        LinkedList<int[]> list = box[h];
        for (int[] i : list) {
            if (i[0] == key) {
                i[1] = value;
                return;
            }
        }
        list.add(new int[] {key, value});
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = getHash(key);
        LinkedList<int[]> list = box[h];

        for (int[] i : list) {
            if (i[0] == key) return i[1];
        }

        return -1;
    }


    public void remove(int key) {
        int h = getHash(key);
        LinkedList<int[]> list = box[h];
        int j = 0;
        for (int[] i : list) {
            if (i[0] == key) {
                list.remove(j);
                return;
            }
            j++;
        }
    }

    private int getHash(int key) {
        return key % BASE;
    }

}
