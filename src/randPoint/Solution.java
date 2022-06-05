package randPoint;

import java.util.Random;

/**
 * @author: ffzs
 * @Date: 2022/6/5 上午9:00
 */
public class Solution {
    double radius, x_center, y_center;
    Random random = new Random();
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        while (true) {
            double x = (random.nextDouble() - 0.5) * 2 * radius;
            double y = (random.nextDouble() - 0.5) * 2 * radius;
            if (x * x + y * y <= radius * radius) return new double[] {x + x_center, y + y_center};
        }

    }
}
