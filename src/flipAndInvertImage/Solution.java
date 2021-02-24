package flipAndInvertImage;

/**
 * @author: ffzs
 * @Date: 2021/2/24 上午8:22
 */
public class Solution {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] ints : A) {
            swap(ints);
        }
        return A;
    }

    private void swap(int[] row){
        int l = 0, r = row.length - 1;
        while (l < r) {
            int tmp = row[l];
            row[l++] = reverse(row[r]);
            row[r--] = reverse(tmp);
        }
        if (l == r) row[l] = reverse(row[l]);
    }

    private int reverse(int i) {
        return 1-i;
    }

}
