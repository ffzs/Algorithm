package maxChunksToSorted2;

/**
 * @author: ffzs
 * @Date: 2022/10/13 下午3:15
 */
public class Solution {

    public int maxChunksToSorted(int[] arr) {
        int maxValue = 0, res = 0;
        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(arr[i], maxValue);
            if (maxValue == i) res += 1;
        }
        return res;
    }

}
