package convertTemperature;

/**
 * @author: ffzs
 * @Date: 2023/3/21 上午9:12
 */
public class Solution {

    public double[] convertTemperature(double celsius) {
        return new double[] {celsius + 273.15, celsius * 1.8 + 32.0};
    }

}
