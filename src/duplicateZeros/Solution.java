package duplicateZeros;

/**
 * @author: ffzs
 * @Date: 2022/6/17 下午5:00
 */
public class Solution {

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int[] queue = new int[n];
        int l = 0, r = 0;

        for (int i = 0; i < n; i++) {
            queue[r++] = arr[i];
            if (queue[l] == 0) {
                arr[i++] = 0;
                if (i >= n) break;
                queue[r++] = arr[i];
            }
            arr[i] = queue[l++];
        }
    }

}
