package rotate;

import java.util.Arrays;

public class rotate1 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int y=0; y<n/2; y++){
            for (int x=0; x<(n+1)/2; x++){
                deepSwap(matrix, x, y,n-x-1, n-y-1);
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void deepSwap(int[][] m, int a, int b, int c, int d){
        int tmp = m[a][b];
        m[a][b] = m[d][a];
        m[d][a] = m[c][d];
        m[c][d] = m[b][c];
        m[b][c] = tmp;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[][] matrix = {{ 5, 1, 9,11}, {2, 4, 8,10}, {13, 3, 6, 7}, {15,14,12,16}};
        rotate(matrix);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
