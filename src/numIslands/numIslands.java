package numIslands;

public class numIslands {
    static int maxY, maxX, res=0;
    public static int numIslands(char[][] grid) {
        maxY = grid.length;
        if (maxY==0) return res;
        maxX = grid[0].length;

        for (int j=0; j<maxY; ++j) {
            for (int i=0; i<maxX; ++i) {
                if (grid[j][i]=='1') {
                    search(j, i, grid);
                    res++;
                }
            }
        }
        return res;
    }

    public static void search(int j, int i, char[][] grid){
        grid[j][i]='0';
        if (j+1<maxY && grid[j+1][i] == '1') search(j+1,i,grid);
        if (j-1>=0 && grid[j-1][i] == '1') search(j-1,i,grid);
        if (i-1>=0 && grid[j][i-1] == '1') search(j,i-1,grid);
        if (i+1<maxX && grid[j][i+1] == '1') search(j,i+1,grid);
    }

    public static void main(String[] args) {
//        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(grid));
    }
}
