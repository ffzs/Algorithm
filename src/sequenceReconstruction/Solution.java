package sequenceReconstruction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ffzs
 * @Date: 2022/7/23 上午10:00
 */
public class Solution {

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int n = nums.length;
        int[] next = new int[n+1];
        int[] index = new int[n+1];
        index[nums[0]] = 0;
        for (int i = 1; i < n; i++) {
            int a = nums[i-1], b = nums[i];
            next[a] = b;
            index[b] = i;
        }
        boolean[] mark = new boolean[n+1];
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int a = sequence[i-1], b = sequence[i];
                if (index[a] >= index[b]) return false;
                if (next[a] == b) mark[a] = true;
            }
        }
        for (int i = 1; i < n; i++) {
            if (i == nums[n-1]) continue;
            if (!mark[i]) return false;
        }

        return true;
    }

}
