package peakIndexInMountainArray;

/**
 * @author: ffzs
 * @Date: 2021/6/15 上午6:48
 */
public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < arr[mid + 1]) l = mid + 1;
            else r = mid;
        }
        return l;
    }

}
