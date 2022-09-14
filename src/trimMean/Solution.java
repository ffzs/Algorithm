package trimMean;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/9/14 上午9:05
 */
public class Solution {

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int sum = 0;
        for (int i = n/20; i < n - n / 20; i++) {
            sum += arr[i];
        }
        return (double) sum / (n / 10 * 9);
    }

}
