package maximumUnits;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/11/15 下午10:05
 */
public class Solution {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)-> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            if (truckSize >= boxType[0]) {
                res += boxType[1] * boxType[0];
                truckSize -= boxType[0];
            }
            else {
                res += boxType[1] * truckSize;
                break;
            }
        }
        return res;
    }

}
