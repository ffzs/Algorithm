package calculateTax;

/**
 * @author: ffzs
 * @Date: 2023/1/23 上午8:31
 */
public class Solution {

    public double calculateTax(int[][] brackets, int income) {
        int pre = 0;
        double res = 0;
        for (int[] bracket : brackets) {
            if (income > bracket[0]) {
                res += (bracket[0] - pre) * bracket[1] / 100d;
            }else {
                res += (income - pre) * bracket[1] / 100d;
                break;
            }
            pre = bracket[0];
        }
        return res;
    }

}
