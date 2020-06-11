package maximalSquare;

public class maximalSquare2 {
    public static int maximalSquare (char[][] matrix) {
        int maxY = matrix.length;
        if(maxY==0) return 0;
        int maxX = matrix[0].length;
        int line = 0;
        int[][] dp = new int[maxY][maxX];
        for (int y=0; y<maxY; ++y){
            for (int x=0; x<maxX; ++x){
                if (matrix[y][x]=='1'){
                    dp[y][x]=1;
                    line=1;
                }
            }
        }

        for (int y=1; y<maxY; ++y){
            for (int x=1; x<maxX; ++x){
                if (matrix[y][x] == '1'){
                    dp[y][x] = Math.min(dp[y-1][x-1], Math.min(dp[y-1][x], dp[y][x-1])) + 1;
                    line = Math.max(dp[y][x], line);
                }
            }
        }
        return line*line;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','0','1','1','0','1','1'},{'1','0','0','0','0','1','0','0'},{'0','1','1','1','0','0','1','1'},{'0','0','0','1','0','0','0','1'},{'0','0','0','0','0','1','1','1'},{'1','1','1','1','1','1','1','1'},{'1','0','0','1','0','1','1','0'},{'0','1','1','0','1','1','1','0'}};
        for (char[] c: matrix){
            System.out.println(c);
        }
        System.out.println(maximalSquare(matrix));
    }
}
