package kthSmallest;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/7/2
 */
public class Solution2 {
    public static int kthSmallest(int[][] matrix, int k) {
        int[] res = new int[matrix.length * matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                res[i*matrix.length + j] = matrix[j][i];
            }
        }
        return quickSort(res, 0, res.length-1, res.length+1-k);
    }

    private static int quickSort(int[] lst, int l, int r, int k){
        if (l == r) return lst[l];
        int mid = lst[l+r >> 1];
        int left = l, right = r;
        while (true) {
            while (lst[left] < mid) left ++;
            while (lst[right] > mid) right --;
            if (left < right) swap(lst, left++, right--);
            else break;
        }
        if (r-right >= k) return quickSort(lst, right+1, r, k);
        else return quickSort(lst, l, right, k-(r-right));
    }

    private static void swap (int[] lst, int i, int j) {
        int tmp = lst[i];
        lst[i] = lst[j];
        lst[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2}, {1,3}};
        System.out.println(kthSmallest(matrix, 4));
    }
}
