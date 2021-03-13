package MyHashSet;

import java.util.LinkedList;

import static javax.swing.text.html.HTML.Tag.BASE;

/**
 * @author: ffzs
 * @Date: 2021/3/13 下午1:57
 */
public class MyHashSet2 {
    private final int BASE = 731;
    private LinkedList[] box;

    public MyHashSet2() {
        box = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            box[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = getHash(key);
        LinkedList<Integer> list = box[h];
        for (Integer i : list) {
            if (i == key) return;
        }
        list.add(key);
    }

    public void remove(int key) {
        int h = getHash(key);
        LinkedList<Integer> list = box[h];
        for (Integer i : list) {
            if (i == key) {
                list.removeFirstOccurrence(i);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = getHash(key);
        LinkedList<Integer> list = box[h];
        for (Integer i : list) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }

    private int getHash(int key) {
        return key % BASE;
    }

}
