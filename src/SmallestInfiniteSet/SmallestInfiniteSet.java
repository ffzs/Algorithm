package SmallestInfiniteSet;

import java.util.TreeSet;

/**
 * @author: ffzs
 * @Date: 2023/11/29 上午8:22
 */
public class SmallestInfiniteSet {
    int p = 1;
    TreeSet<Integer> set;
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
    }

    public int popSmallest() {
        if (set.isEmpty()) return p++;
        int v = set.first();
        set.remove(v);
        return v;
    }

    public void addBack(int num) {
        if (num >= p) return;
        set.add(num);
    }

}
