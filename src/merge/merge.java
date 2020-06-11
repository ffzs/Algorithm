package merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class merge {
    public static int[][] merge (int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        int[][] temp = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > temp[index][1]){
                temp[++index] = interval;
            }else{
                temp[index][1] = Math.max(temp[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(temp, index+1);
    }

    public static int[][] merge2 (int[][] intervals){
        int maxNum=0;
        for(int[] in: intervals){
            for(int i: in){
                if (i>maxNum) maxNum=i;
            }
        }

        int[] temp = new int[maxNum+2];
        for (int[] ints : intervals) {
            for (int j = ints[0]+1; j < ints[1]; ++j) {
                if (temp[j] != 1) temp[j] = 1;
            }
            if (temp[ints[0]] == 0) temp[ints[0]]=-1;
            else if(temp[ints[0]] == -1 && temp[ints[0]-1]!=0) temp[ints[0]]=1;
            if (temp[ints[1]] == 0 ) temp[ints[1]]=-1;
            else if (temp[ints[1]] == -1 && temp[ints[1]+1]!=0) temp[ints[1]]=1;
        }
        System.out.println(Arrays.toString(temp));
        List<int[]> rlist = new ArrayList<>();
        int start = -1;
        for (int i=0; i<temp.length; ++i){
            if(temp[i]==-1 && start==-1) {
                start = i;
            }
            else if(temp[i]==-1 && start!=-1){
                rlist.add(new int[]{start, i});
                start = -1;
            }
        }
        int[][] res = new int[rlist.size()][2];
        for (int i=0; i<res.length; ++i){
            res[i] = rlist.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = new int[][]{{1,4},{4,5}};
//        int[][] intervals = new int[][]{{1,4},{5,6}};
        int[][] intervals = new int[][]{{1,4},{0,0}};
//        int[][] intervals = new int[][]{{1,4},{1,4}};
        System.out.println(Arrays.deepToString(merge2(intervals)));
    }
}
