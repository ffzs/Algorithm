package reachNumber;

import javax.swing.table.TableRowSorter;

/**
 * @author: ffzs
 * @Date: 2022/11/4 下午5:30
 */
public class Solution {

    public int reachNumber(int target) {
        target = Math.abs(target);
        int i = 1;
        while (target >= i) {
            target -= i;
            i += 1;
        }
        if (target % 2 == 0) return i-1;
        if ((i - target) % 2 == 0) return i;
        else return i + 1;
    }

}
