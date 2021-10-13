package peakIndexInMountainArray2;

/**
 * @author: ffzs
 * @Date: 2021/10/14 上午7:05
 */
public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > arr[mid - 1]) l = mid;
            else r = mid - 1;
        }
        return l;
    }
}
