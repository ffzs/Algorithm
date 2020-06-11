package movingCount;

import java.util.LinkedList;
import java.util.Queue;

public class movingCount {
    public static int movingCount(int m, int n, int k){
        int counter = 0;
        Queue<int[]> queue= new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()){
            int[] pos = queue.poll();
            int i = pos[0], j = pos[1];
            if ((numSum(i) + numSum(j))>k) continue;
            counter ++;
            if (i+1<m && j%10==0) queue.add(new int[]{i+1, j});
            if ((i==0 || (j+1)%10 != 0) && (j+1)<n) queue.add(new int[]{i, j+1});
        }
        return counter;
    }

    public static int numSum(int num){
        int s = 0;
        while (num != 0){
            s += num % 10;
            num = num / 10;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(2,3,1));
    }
}

