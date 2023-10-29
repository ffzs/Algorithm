package hIndex2;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2023/10/29 上午9:13
 */
public class Solution {

    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h = n-i;
            if (citations[i] >= h) return h;
        }
        return 0;
    }

}
