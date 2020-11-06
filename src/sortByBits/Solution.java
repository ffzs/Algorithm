package sortByBits;

import java.util.*;

/**
 * @author: ffzs
 * @Date: 2020/11/6 上午8:08
 */

public class Solution {

    public int[] sortByBits(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int c1 = numOne(arr[i]);
            res[i] = c1 * 100000 + arr[i];
        }

        Arrays.sort(res);
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] % 100000;
        }

        return res;
    }

    private int numOne (int i) {
        int count = 0;
        while (i != 0) {
            i = (i-1)&i;
            count++;
        }
        return count;
    }

}
