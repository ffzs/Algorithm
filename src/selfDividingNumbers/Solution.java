package selfDividingNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/3/31 上午8:37
 */
public class Solution {
    static int[] isSelf = new int[10001];
    static {
        Arrays.fill(isSelf, -1);
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelf[i] == -1) {
                isSelf[i] = isSelfDividingNumber(i)? 1 : 0;
            }
            if (isSelf[i] == 1) res.add(i);
        }
        return res;
    }

    static private boolean isSelfDividingNumber(int num) {
        int tmp = num;
        while (num > 0) {
            int remain = num % 10;
            if (remain == 0 || tmp % remain != 0) return false;
            num /= 10;
        }
        return true;
    }
}
