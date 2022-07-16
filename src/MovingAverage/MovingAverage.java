package MovingAverage;

import java.util.Arrays;

/**
 * @author: ffzs
 * @Date: 2022/7/16 上午10:14
 */
public class MovingAverage {

    /** Initialize your data structure here. */
    int idx, size;
    double sum;
    int[] vals;
    public MovingAverage(int size) {
        idx = 0;
        this.size = size;
        vals = new int[size];
    }

    public double next(int val) {
        sum += val;
        if (idx >= size) sum -= vals[idx % size];
        vals[idx%size] = val;
        idx += 1;
        return sum / Math.min(idx,size);
    }
}
