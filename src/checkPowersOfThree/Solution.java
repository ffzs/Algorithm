package checkPowersOfThree;

/**
 * @author: ffzs
 * @Date: 2022/12/9 下午7:59
 */
public class Solution {

    public boolean checkPowersOfThree(int n) {
        while (n != 0) {
            if (n % 3 == 2) return false;
            n /= 3;
        }
        return true;
    }

}
