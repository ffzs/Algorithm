package maximalSquare;

import java.util.Arrays;

public class maximalSquare {
    public static int maximalSquare (char[][] matrix) {
        int maxY = matrix.length;
        if(maxY==0) return 0;
        int maxX = matrix[0].length;
        int line = 0;
        for (int y=0; y<maxY-line; ++y){
            for (int x=0; x<maxX-line; ++x) {
                if (matrix[y][x]=='1'){
                    if (x!=maxX-1&&y!=maxY-1&&matrix[y][x+1]=='1'&&matrix[y+1][x]=='1'&&matrix[y+1][x+1]=='1'){
                        line = Math.max(line, 2);
                        int maxLine = Math.min(maxX-x, maxY-y);
                        if (maxLine>2) {
                            line = Math.max(line, checkSquare(x,y,maxLine,matrix));
                        }
                    }
                    line = Math.max(line, 1);
                }
            }
        }
        return line*line;
    }

    static int checkSquare (int x, int y, int maxLine, char[][] matrix) {
        for (int i=2; i<maxLine; ++i){
            for (int j=0; j<=i; ++j){
                if (matrix[y+i][x+j]=='0'|| matrix[y+j][x+i]=='0') return i;
            }
        }
        return maxLine;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','0','1','1','0','1','1'},{'1','0','0','0','0','1','0','0'},{'0','1','1','1','0','0','1','1'},{'0','0','0','1','0','0','0','1'},{'0','0','0','0','0','1','1','1'},{'1','1','1','1','1','1','1','1'},{'1','0','0','1','0','1','1','0'},{'0','1','1','0','1','1','1','0'}};
        for (char[] c: matrix){
            System.out.println(c);
        }
        System.out.println(maximalSquare(matrix));
    }
}
