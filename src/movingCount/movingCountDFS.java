package movingCount;

import java.util.Arrays;

public class movingCountDFS {

    static int M,N,K,counter=0;
    public static int movingCount(int m, int n, int k) {
        M = m;
        N = n;
        K = k;
        dfs(0, 0);
        return counter;
    }

    public static void dfs(int i, int j) {
        if ((numSum(i) + numSum(j))<=K) {
            counter ++;
            if((i+1)<M && j%10==0) dfs(i+1,j);
            if((i==0 || (j+1)%10 != 0) && (j+1)<N) dfs(i,j+1);
        }
    }

    public static int numSum(int num) {
        int s = 0;
        while (num != 0) {
            s += num % 10;
            num = num / 10;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(3,2,17));
    }
}
