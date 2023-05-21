package storeWater;

/**
 * @author: ffzs
 * @Date: 2023/5/21 上午8:35
 */
public class Solution {

    public int storeWater(int[] bucket, int[] vat) {
        int res = 0, n = bucket.length, mv = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < n; i++) {
            if (bucket[i] == 0) {
                res += 1;
                bucket[i]=1;
            }
            int num = getNum(vat[i] , bucket[i]);
            max = Math.max(num, max);
        }
        if (max == 0) return 0;
        for (int i = 1; i <= max; i++) {
            int t = 0;
            for (int j = 0; j < n; j++) {
                if (vat[j] - i * bucket[j] > 0) {
                    t += getNum(vat[j], i) - bucket[j];
                }
            }
            mv = Math.min(mv, i + t);
        }
        return mv==Integer.MAX_VALUE?0:mv + res;
    }

    private int getNum (int vat, int bucket) {
        if (bucket == 0) return Integer.MAX_VALUE;
        return vat / bucket + (vat % bucket == 0? 0:1);
    }

}
