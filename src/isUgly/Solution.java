package isUgly;

/**
 * @author: ffzs
 * @Date: 2021/4/10 上午8:08
 */
public class Solution {

    public boolean isUgly(int n) {
        if (n == 1 || n == 2 || n == 3 || n == 5) return true;
        else if (n <= 0) return false;

        if (n%2 == 0) return isUgly(n/2);
        else if (n%3 == 0) return isUgly(n/3);
        else if (n%5 == 0) return isUgly(n/5);
        else return false;
    }

}
