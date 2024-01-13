package temp;

import java.util.Arrays;

public class Solution {
    

    private void bubbleSort (int[] arr) {
        int n = arr.length, t;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    private void quickSort (int[] arr, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        int pvt = arr[l];
        while (i < j) {
            while (i < j && arr[j] >= pvt) j--;
            while (i < j && arr[i] <= pvt) i++;
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        arr[l] = arr[i];
        arr[i] = pvt;
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }
}
