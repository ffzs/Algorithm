package smallestK;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2021/9/3 上午6:42
 */
public class Solution {

    public int[] smallestK(int[] arr, int k) {
        if (k >= arr.length) return arr;
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    static private void quickSort(int[] lst, int l, int r, int k) {
        if (l >= r) return;

        int mid = (l + r) >>> 1;

        int key = lst[mid];
        lst[mid] = lst[l];
        lst[l] = key;

        int ll = l, rr = r;
        while (ll < rr) {
            while (ll < rr && lst[rr] >= key) --rr;
            lst[ll] = lst[rr];
            while (ll < rr && lst[ll] <= key) ++ll;
            lst[rr] = lst[ll];
        }
        lst[ll] = key;
        if (ll > k) quickSort(lst, l, ll -1, k);
        else if (ll == k) return;
        else quickSort(lst, ll + 1, r, k);
    }

}
