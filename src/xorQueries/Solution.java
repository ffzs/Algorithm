package xorQueries;

/**
 * @author: ffzs
 * @Date: 2021/5/13 下午5:24
 */
public class Solution {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] tmp = new int[n+1];
        for (int i = 0; i < arr.length; i++) {
            tmp[i+1] = tmp[i] ^ arr[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = tmp[queries[i][0]] ^ tmp[queries[i][1] + 1];
        }
        return res;
    }

}
