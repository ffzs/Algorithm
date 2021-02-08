package maxTurbulenceSize;

/**
 * @author: ffzs
 * @Date: 2021/2/8 上午8:52
 */
public class Solution {

    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        if (n == 1) return n;
        if (n == 2) return arr[0] == arr[1] ? 1: 2;

        int res = 1, left = 0, right = 0;
        while (right < n - 1) {
            if (left == right) {
                if (arr[right] == arr[right + 1]) left ++;
                right ++;
            }
            else {
                if ((arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) || (arr[right - 1] < arr[right] && arr[right] > arr[right + 1])) right++;
                else left = right;
            }

            res = Math.max(res, right-left+1);
        }


        return res;
    }

}
