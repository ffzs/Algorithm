package spiralOrder;

import java.util.Arrays;

/**
 * @author ffzs
 * @describe
 * @date 2020/6/5
 */
public class Solution {
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int y = matrix.length, x = matrix[0].length;
        int[] res = new int[x*y];
        boolean[][] step = new boolean[y+2][x+2];

        for (int i = 0; i < x+2; i++) {
            step[0][i] = true;
            step[y+1][i] = true;
        }

        for (int i = 1; i < y+1; i++) {
            step[i][0] = true;
            step[i][x+1] = true;
        }


        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int[] start = {1,1};
        res[0] = matrix[0][0];
        step[1][1] = true;
        int i = 1, s = 0;
        while (true) {
            int[] direct = directions[s];
            while (!step[start[0]+direct[0]][start[1]+direct[1]]) {
                start[0] += direct[0];
                start[1] += direct[1];
                step[start[0]][start[1]] = true;
                res[i] = matrix[start[0]-1][start[1]-1];
                i++;
            }
            s = (s + 1) % 4;
            if (i == x*y) return res;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }
}
