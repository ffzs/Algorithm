package others;

import java.util.Arrays;

public class testK {
    public static void gameOfLife(int[][] board) {
        int xmax = board.length;
        int ymax = board[0].length;
        int[][] tmp = new int[xmax+2][ymax+2];

        for (int i=1; i < ymax+1; i++) {
            for (int j=1; j< xmax+1; j++){
                tmp[j][i] = board[j-1][i-1];
            }
        }

        int[][] steps = {{-1,-1}, {-1,0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int x=1; x < ymax+1; x++) {
            for (int y=1; y< xmax+1; y++){
                int live_num = 0;
                for (int[] step: steps) {
                    int xx = x+step[0];
                    int yy = y+step[1];
                    live_num += tmp[yy][xx];
                }
                if (tmp[y][x] ==0 && live_num ==3) board[y-1][x-1] = 1;
                else if(tmp[y][x] ==1 && live_num !=2 && live_num != 3) board[y-1][x-1] = 0;
            }
        }
        System.out.println(Arrays.deepToString(board));
    }

    public static void main(String[] args) {
        int[][] a = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(a);
    }
}
