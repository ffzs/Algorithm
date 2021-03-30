package searchMatrix;

/**
 * @author: ffzs
 * @Date: 2021/3/30 上午8:42
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] rows = new int[m+1];
        for (int i = 0; i < m; i++) {
            rows[i] = matrix[i][0];
        }
        rows[m] = matrix[m-1][n-1];

        if (target < rows[0] || target > rows[m]) return false;

        int aim = biSearch(rows, 0, m, target, false);
        int[] row = matrix[aim];
        int idx = biSearch(row, 0, n-1, target, true);
        return row[idx] == target;
    }

    public int biSearch (int[] nums, int l, int r, int target, boolean isRow) {
        if (l >= r) return isRow? l: l-1;
        int mid = (l + r) >>> 1;
        System.out.println(mid);
        if (target > nums[mid]) return biSearch(nums, mid + 1, r, target, isRow);
        else if (target == nums[mid]) return mid;
        else return biSearch(nums, l, mid, target, isRow);
    }
}

class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] row = {1,3};
//        int[] row = {1,3,5,7};
        System.out.println(solution.biSearch(row, 0, row.length -1, 3, false));
    }
}
