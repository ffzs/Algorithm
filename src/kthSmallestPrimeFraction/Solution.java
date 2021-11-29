package kthSmallestPrimeFraction;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: ffzs
 * @Date: 2021/11/29 上午7:45
 */
public class Solution {

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double l = 0L, r = 1L;

        while (l < r) {
            double mid = (l + r) / 2;
            int[] cur = helper(arr, mid);
            if (cur[2] == k) return new int[]{cur[0], cur[1]};
            else if (cur[2] > k) r = mid;
            else l = mid;
        }
        return new int[0];
    }

    private int[] helper(int[] arr, double mid) {
        int cnt = 0;
        int a = arr[0];
        int b = arr[arr.length - 1];
        int i = -1;

        for (int j = 1; j < arr.length; j++) {
            while (i < j - 1 && arr[i + 1] < mid * arr[j]) i++;
            cnt = i + 1;
            if (i >= 0 && arr[i] * b > arr[j] * a) {
                a = arr[i];
                b = arr[j];
            }
        }
        return new int[]{a, b, cnt};
    }

}
