import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(",");
        int m = Integer.parseInt(s[0]), n = Integer.parseInt(s[1]);
        int [][] matrix = new int[m][n];
        for (int i = 0; i < m; ++i) {
            String[] str = in.nextLine().split(",");
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = str[j].equals("M") ? 1:0;
            }
        }
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 1) {
                    res = Math.max(search(matrix, i, j, m, n), res);
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(res);
    }

    private static int search (int[][] matrix, int x, int y, int m, int n) {
        int ret = 1;
        int cnt = 1;
        int i = x, j = y;
        while (isLegal(m,n,++i,j) && matrix[i][j] == 1) {
            cnt ++;
            matrix[i][j] = 2;
        }
        ret = Math.max(ret, cnt);
        cnt = 1;
        i = x;
        j = y;
        while (isLegal(m,n,i,++j) && matrix[i][j] == 1) {
            cnt ++;
            matrix[i][j] = 2;
        }
        ret = Math.max(ret, cnt);
        cnt = 1;
        i = x;
        j = y;
        while (isLegal(m,n,++i,++j) && matrix[i][j] == 1) {
            cnt ++;
            matrix[i][j] = 2;
        }
        ret = Math.max(ret, cnt);
        cnt = 1;
        i = x;
        j = y;
        while (isLegal(m,n,++i,--j) && matrix[i][j] == 1) {
            cnt ++;
            matrix[i][j] = 2;
        }
        ret = Math.max(ret, cnt);
        return ret;
    }

    private static boolean isLegal(int m, int n, int i, int j) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }

}