package findRelativeRanks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: ffzs
 * @Date: 2021/12/2 上午8:06
 */
public class Solution {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] res = new String[n];

        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idx.put(score[i], i);
        }

        Arrays.sort(score);
        for (int i = 0; i < n; ++i) {
            res[idx.get(score[n-i-1])] = getRank(i);
        }

        return res;
    }

    private String getRank(int i) {
        i = i + 1;
        if (i == 1) return  "Gold Medal";
        else if (i == 2) return  "Silver Medal";
        else if (i == 3) return  "Bronze Medal";
        else return String.valueOf(i);
    }


}
