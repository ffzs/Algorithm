package others;

import java.util.Arrays;

public class rotate {
    public static void rotate(int[][] matrix) {
        int maxN = matrix.length;

        for (int i=0; i<(maxN/2); i++) {
            swap(matrix, i, maxN-1-i);
        }

        for(int y=0; y<maxN-1; y++){
            for (int x=maxN-1; x>y; x--){
                deepSwap(matrix, x, y);
            }
        }
    }

    public static void swap(int[][] matrix, int y1, int y2){
        int[] tmp = matrix[y1];
        matrix[y1] = matrix[y2];
        matrix[y2] = tmp;
    }

    public static void deepSwap(int[][] matrix, int x, int y){
        int tmp = matrix[x][y];
        matrix[x][y] = matrix[y][x];
        matrix[y][x] = tmp;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[][] matrix = {{ 5, 1, 9,11}, {2, 4, 8,10}, {13, 3, 6, 7}, {15,14,12,16}};
        rotate(matrix);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
