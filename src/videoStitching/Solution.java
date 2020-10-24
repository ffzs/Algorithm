package videoStitching;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2020/10/24 上午10:44
 */
public class Solution {

    public static int videoStitching(int[][] clips, int T) {
        List<List<Integer>> tmp = new ArrayList<>(T+1);
        for (int i = 0; i <= T; i++) tmp.add(new ArrayList<>());

        for (int i = 0; i < clips.length; i++) {
            if (clips[i][0] < T) tmp.get(clips[i][0]).add(i);
        }

        int cur = 0, pre = 0, count=0, max;
        while (cur < T) {
            max = pre;
            for (int i = pre; i <= cur; i++) {
                List<Integer> lst = tmp.get(i);
                for (Integer integer : lst) {
                    max = Math.max(clips[integer][1], max);
                }
            }
            if (max == pre) return -1;
            pre = cur+1;
            cur = max;
            count++;
            if (max >= T) return count;
        }
        return -1;
    }
}

class Test {
    public static void main(String[] args) {
        int[][] clips = {{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
//        int[][] clips = {{0,4},{2,8}};
        System.out.println(Solution.videoStitching(clips, 10));
    }
}
